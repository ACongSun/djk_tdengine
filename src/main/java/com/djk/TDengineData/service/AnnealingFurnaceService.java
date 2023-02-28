package com.djk.TDengineData.service;

import com.djk.TDengineData.domain.AnnealingFurnace;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Admin
* @description 针对表【annealing_furnace】的数据库操作Service
* @createDate 2023-02-28 09:46:14
*/
public interface AnnealingFurnaceService extends IService<AnnealingFurnace> {
    String saveBatchoneAnneaFur(String sql, Integer MachineNum);
}
