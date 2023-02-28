package com.djk.TDengineData.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djk.TDengineData.domain.RewindRoll;
import com.djk.TDengineData.utils.MachineTypeEnum;
import com.djk.TDengineData.service.RewindRollService;
import com.djk.TDengineData.mapper.RewindRollMapper;
import com.djk.TDengineData.utils.TDengineData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author Admin
* @description 针对表【rewind_roll】的数据库操作Service实现
* @createDate 2023-02-27 17:38:02
*/
@Service
public class RewindRollServiceImpl extends ServiceImpl<RewindRollMapper, RewindRoll>
    implements RewindRollService{

    @Resource
    private RewindRollMapper rewindRollMapper;

    @Override
    public String saveBatchRewindRoll(String sql) {
        try {
            List<Map<String, String>> list = new TDengineData().getTDengineData(MachineTypeEnum.REWINDROLL, sql);
            ArrayList<RewindRoll> rewindRollList = new ArrayList<>();
            if (list == null || list.size() == 0){
                return "暂无新数据";
            }
            list.forEach(
                    item ->{
                        RewindRoll rewindRoll = JSON.parseObject(JSON.toJSONString(item), RewindRoll.class);
                        rewindRollList.add(rewindRoll);
                    }
            );
            Boolean isSucc = rewindRollMapper.saveBatchRewindRoll(rewindRollList);
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




