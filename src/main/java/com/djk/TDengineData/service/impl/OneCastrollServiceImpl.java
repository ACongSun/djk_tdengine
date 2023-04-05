package com.djk.TDengineData.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djk.TDengineData.domain.OneCastRoll;
import com.djk.TDengineData.domain.RewindRoll;
import com.djk.TDengineData.utils.MachineTypeEnum;
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
    public String saveBatchOneCast(String sql, Integer machineNum) {
        try {
            List<Map<String, String>> list =  new TDengineData().getTDengineData(MachineTypeEnum.COLSCASTROLL, sql);
            List<OneCastRoll> castrollList = new ArrayList<>();
            if (list == null || list.size() == 0){
                return "暂无新数据";
            }
            list.forEach(
                    item ->{
                        OneCastRoll oneCastroll = JSON.parseObject(JSON.toJSONString(item), OneCastRoll.class);
                        castrollList.add(oneCastroll);
                    }
            );
            Boolean isSucc = null;
            switch (machineNum){
                case 1:
                    isSucc = oneCastrollMapper.saveBatchOneCast(castrollList);
                    break;
                case 2:
                    isSucc = oneCastrollMapper.saveBatchTwoCast(castrollList);
                    break;
                case 3:
                    isSucc = oneCastrollMapper.saveBatchThreeCast(castrollList);
                    break;
                case 4:
                    isSucc = oneCastrollMapper.saveBatchFourCast(castrollList);
                    break;
                case 5:
                    isSucc = oneCastrollMapper.saveBatchFiveCast(castrollList);
                    break;
                default:
                    break;
            }
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

    @Override
    public ArrayList<Object> getHistoryList(String sql, String type) {
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<String> ts = new ArrayList<>();
        ArrayList<Double> sx = new ArrayList<>();
        String[] colsCastRoll = MachineTypeEnum.getColsCastRoll(MachineTypeEnum.COLSCASTROLL);
        int sxWhere = 0;
        for (sxWhere = 0; sxWhere < colsCastRoll.length; sxWhere++) {
            if (colsCastRoll[sxWhere].equals(type)){
                break;
            }
        }
        try {
            List<Map<String, String>> list = new TDengineData().getTDengineData(MachineTypeEnum.COLSCASTROLL, sql);
            if (list == null || list.size() == 0) {
                log.info("查询的数据为null");
            } else {
                list.forEach(
                        item -> {
                            ts.add(item.get("ts"));
                            sx.add(Double.parseDouble(item.get(type)));
                        }
                );
            }
            objects.add(ts);
            objects.add(sx);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("SQL异常");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("连接异常");
        }
        return objects;
    }




}




