package com.djk.TDengineData.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djk.TDengineData.domain.OneCastRoll;
import com.djk.TDengineData.dto.MachineTypeEnum;
import com.djk.TDengineData.service.OneCastrollService;
import com.djk.TDengineData.mapper.OneCastrollMapper;
import com.djk.TDengineData.utils.TDengineData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author Admin
* @description 针对表【one_castroll】的数据库操作Service实现
* @createDate 2023-02-22 16:34:34
*/
@Slf4j
@Service
public class OneCastrollServiceImpl extends ServiceImpl<OneCastrollMapper, OneCastRoll>
    implements OneCastrollService{

    @Resource
    OneCastrollMapper oneCastrollMapper;

    @Override
    public String saveBatchOneCast(String sql) {
        try {
            List<Map<String, String>> list = new TDengineData().getTDengineData(MachineTypeEnum.COLSCASTROLL1, sql);
            if (list == null || list.size() == 0){
                return "暂无新数据";
            }
            List<OneCastRoll> castrollList = new ArrayList<>();
            list.forEach(
                    item ->{
                        com.djk.TDengineData.domain.OneCastRoll oneCastroll = JSON.parseObject(JSON.toJSONString(item), com.djk.TDengineData.domain.OneCastRoll.class);
                        castrollList.add(oneCastroll);
                    }
            );
            Boolean isSucc = oneCastrollMapper.saveBatchOneCast(castrollList);
            if (isSucc){
                return "成功";
            }
            return "失败";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "SQL异常";
        } catch (IOException e) {
            e.printStackTrace();
            return "连接异常";
        }
    }
}




