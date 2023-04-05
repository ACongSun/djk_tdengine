package com.djk.TDengineData.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djk.TDengineData.domain.AnnealingFurnace;
import com.djk.TDengineData.service.AnnealingFurnaceService;
import com.djk.TDengineData.mapper.AnnealingFurnaceMapper;
import com.djk.TDengineData.utils.MachineTypeEnum;
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
* @description 针对表【annealing_furnace】的数据库操作Service实现
* @createDate 2023-02-28 09:46:14
*/
@Slf4j
@Service
public class AnnealingFurnaceServiceImpl extends ServiceImpl<AnnealingFurnaceMapper, AnnealingFurnace>
    implements AnnealingFurnaceService{

    @Resource
    private AnnealingFurnaceMapper annealingFurnaceMapper;

    @Override
    public String saveBatchoneAnneaFur(String sql, Integer MachineNum) {
        try {
            List<Map<String, String>> list =  new TDengineData().getTDengineData(MachineTypeEnum.QUENCHINGFURNACE, sql);
            ArrayList<AnnealingFurnace> furnaceList = new ArrayList<>();
            if (list == null || list.size() == 0) {
                return "暂无新数据";
            }
            list.forEach(
                    item -> {
                        AnnealingFurnace annealingFurnace = JSON.parseObject(JSON.toJSONString(item), AnnealingFurnace.class);
                        furnaceList.add(annealingFurnace);
                    }
            );
            Boolean isSucc = null;
            switch (MachineNum){
                case 1:
                    isSucc = annealingFurnaceMapper.saveBatchoneAnneaFur(furnaceList, "one_annea_fur");
                    break;
                case 2:
                    isSucc = annealingFurnaceMapper.saveBatchoneAnneaFur(furnaceList, "two_annea_fur");
                    break;
                case 3:
                    isSucc = annealingFurnaceMapper.saveBatchoneAnneaFur(furnaceList, "three_annea_fur");
                    break;
                case 4:
                    isSucc = annealingFurnaceMapper.saveBatchoneAnneaFur(furnaceList, "four_annea_fur");
                    break;
                case 5:
                    isSucc = annealingFurnaceMapper.saveBatchoneAnneaFur(furnaceList, "five_annea_fur");
                    break;
                case 6:
                    isSucc = annealingFurnaceMapper.saveBatchoneAnneaFur(furnaceList, "six_annea_fur");
                    break;
                case 7:
                    isSucc = annealingFurnaceMapper.saveBatchoneAnneaFur(furnaceList, "seven_annea_fur");
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
        String[] colsFurnace = MachineTypeEnum.getColsCastRoll(MachineTypeEnum.QUENCHINGFURNACE);
        int sxWhere = 0;
        for (sxWhere = 0; sxWhere < colsFurnace.length; sxWhere++) {
            if (colsFurnace[sxWhere].equals(type)){
                break;
            }
        }
        try {
            List<Map<String, String>> list = new TDengineData().getTDengineData(MachineTypeEnum.QUENCHINGFURNACE, sql);
            if (list == null || list.size() == 0) {
                log.info("查询的数据为null");
            } else {
                list.forEach(
                        item -> {
                            ts.add(item.get("ts"));
                            if ("false".equals(item.get(type))){
                                sx.add(0.0);
                            }else if ("true".equals(item.get(type))){
                                sx.add(1.0);
                            }else{
                                sx.add(Double.parseDouble(item.get(type)));
                            }
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




