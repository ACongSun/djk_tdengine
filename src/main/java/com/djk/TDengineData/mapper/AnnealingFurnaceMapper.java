package com.djk.TDengineData.mapper;

import com.djk.TDengineData.domain.AnnealingFurnace;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Admin
* @description 针对表【annealing_furnace】的数据库操作Mapper
* @createDate 2023-02-28 09:46:14
* @Entity com.djk.TDengineData.domain.AnnealingFurnace
*/
@Mapper
public interface AnnealingFurnaceMapper extends BaseMapper<AnnealingFurnace> {

    Boolean saveBatchoneAnneaFur(@Param("list") List<AnnealingFurnace> list, @Param("machineNum") String machineNum);

}




