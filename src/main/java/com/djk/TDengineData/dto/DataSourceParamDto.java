package com.djk.TDengineData.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataSourceParamDto {
    private String host;

    private Integer port;

    private String username;

    private String password;

    private String database;

}
