package com.djk.TDengineData.service;

import com.djk.TDengineData.domain.OneCastRoll;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Admin
* @description 针对表【one_castroll】的数据库操作Service
* @createDate 2023-02-22 16:34:34
*/
public interface OneCastrollService extends IService<OneCastRoll> {

    /**
     * 批量插入 存在更新 不存在插入
     * @return
     */
    String saveBatchOneCast(String sql);
}
