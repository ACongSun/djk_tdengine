package com.djk.TDengineData.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.djk.TDengineData.dto.DataSourceParamDto;
import com.djk.TDengineData.dto.TdengineResult;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 孙少聪
 * @Date 2023/2/22 09:06:16
 * @Description 获取TDengine数据的工具类
 */

public class TDengineData {

    /**
     * 获取TDengine数据
     * @throws SQLException
     * @throws IOException
     */
    public List<Map<String, String>> getTDengineData(MachineTypeEnum machineType, String sql) throws SQLException, IOException {
        //DataSourceParamDto dataSource = new DataSourceParamDto();
        DataSourceParamDto dataSource = new DataSourceParamDto()
                .setHost("10.82.23.161")
                .setPort(6041)
                .setDatabase("thingsboard")
                .setUsername("root")
                .setPassword("taosdata");
        List<Map<String, String>> result = queryResult(dataSource, sql, machineType);
        return result;
    }

    /**
     * 处理TDengine返回的数据
     */
    private List<Map<String, String>> queryResult(DataSourceParamDto dataSource, String sql, MachineTypeEnum machineType)
            throws SQLException, IOException {

        String[] cols = MachineTypeEnum.getColsCastRoll(machineType);

        /** 以下是测试环境的代码 */
        /*String resp = HttpRequest.post(
                "https://" +
                "console-mock.apipost.cn" +
                "/mock/5eecb9fa-eb84-4f06-86b2-a7f7bf6876b8" +
                "/tdengine3")
                .charset("utf-8")
                .header("Authorization", "Basic cm9vdDp0YW9zZGF0YQ==")
                .body(sql)
                .execute()
                .body();*/
        /** 以下是真实环境的代码 */
        String user = dataSource.getUsername();
        String password = dataSource.getPassword();
        String encode = Base64.encode(user + ":" + password);
        String resp =
                HttpRequest.post(
                        "http://"
                                + dataSource.getHost()
                                + ":"
                                + dataSource.getPort()
                                + "/rest/sql/"
                                + dataSource.getDatabase())
                        .charset("utf-8")
                        .header("Authorization", "Basic " + encode)
                        .body(sql)
                        .execute()
                        .body();
        /** 以上是真实环境的代码 */

        TdengineResult result = JSON.parseObject(resp, TdengineResult.class);
        // 连接错误
        if (result == null) {
            throw new IOException("error:连接错误");
        }
        if (TdengineResult.ERROR_STATUS.equals(result.getStatus())) {
            throw new SQLException(String.format("执行错误-%d:%s", result.getCode(), result.getDesc()));
        }
        // 结果集解析
        List<List<String>> data = result.getData().stream().limit(1000).collect(Collectors.toList());
        List<String> head = result.getHead();
        Map<String, String> needCols = needCols(head, cols);
        List<Map<String, String>> res = new ArrayList<>();
        data.forEach(
            item -> {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < head.size(); i++) {
                    map.put(needCols.get(head.get(i)), item.get(i));
                }
                res.add(map);
            }
        );
        return res;

    }

    /**
     * 处理需要的列，改名
     */
    private Map<String, String> needCols(List<String> head, String[] cols) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < head.size(); i++) {
            map.put(head.get(i), cols[i]);
        }
        return map;
    }
}
