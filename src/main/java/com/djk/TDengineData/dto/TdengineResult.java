package com.djk.TDengineData.dto;

import lombok.Data;

import java.util.List;

@Data
public class TdengineResult {

    public static final String ERROR_STATUS = "error";

    String status;

    List<String> head;

    List<List<String>> data;

    Integer rows;

    Integer code;

    String desc;

}
