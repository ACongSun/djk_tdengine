package com.djk.TDengineData.service;

import com.djk.TDengineData.domain.OneCastRoll;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    String saveBatchOneCast(String sql, Integer machineNum);

    /**
     * 获取一段时间内的历史数据
     */
    ArrayList<Object> getHistoryList(String sql, String type);

    /**
     * 测试查询一段时间的数据
     * @param sql
     * @return
     */
//    ArrayList<Object> getalllist(String sql) throws SQLException, IOException;
}
