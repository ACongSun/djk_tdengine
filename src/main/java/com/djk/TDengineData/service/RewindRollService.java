package com.djk.TDengineData.service;

import com.djk.TDengineData.domain.RewindRoll;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
* @author Admin
* @description 针对表【rewind_roll】的数据库操作Service
* @createDate 2023-02-27 17:38:02
*/
public interface RewindRollService extends IService<RewindRoll> {

    String saveBatchRewindRoll(String sql);

    /**
     * 获取一段时间内的历史数据
     */
    ArrayList<Object> getHistoryList(String sql, String type);

}
