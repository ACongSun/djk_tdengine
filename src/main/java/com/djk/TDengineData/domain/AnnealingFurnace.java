package com.djk.TDengineData.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @TableName one_annea_fur
 */
@TableName(value ="one_annea_fur")
@Data
public class AnnealingFurnace implements Serializable {
    /**
     * 采集时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date ts;

    /**
     * 一区温度
     */
    private Double zoneOneT;

    /**
     * 二区温度
     */
    private Double zoneTwoT;

    /**
     * 三区温度
     */
    private Double zoneThreeT;

    /**
     * 料温
     */
    private Double meterialT;

    /**
     * 一区加热输出
     */
    private Double zoneOneHotOutput;

    /**
     * 二区加热输出
     */
    private Double zoneTwoHotOutput;

    /**
     * 三区加热输出
     */
    private Double zoneThreeHotOutput;

    /**
     * 设定温度
     */
    private Double setT;

    /**
     * 期望温度
     */
    private Double desiredT;

    /**
     * 排烟风扇频率设定值
     */
    private Double exhaustFanSetF;

    /**
     * 进风风机频率设定值
     */
    private Double inFanSetF;

    /**
     * 控制类型
     */
    private Double controlType;

    /**
     * 料温控制
     */
    private Double materialControlT;

    /**
     * 报警温度设定值
     */
    private Double warnSetT;

    /**
     * 破碎机操作侧电流
     */
    private Double crusherOperatingSideA;

    /**
     * 炉门冷却水断流
     */
    private Boolean furnaceDoorCoolWater;

    /**
     * 风机冷却水断流
     */
    private Boolean funCoolWater;

    /**
     * 回水温度高
     */
    private Boolean returnWaterHighT;

    /**
     * 冷却水压力上限
     */
    private Boolean coolWaterUpLimit;

    /**
     * 压缩空气1压力低
     */
    private Boolean compressedAirOneLowPressure;

    /**
     * 压缩空气2压力低
     */
    private Boolean compressedAirTwoLowPressure;

    /**
     * 升温
     */
    private Boolean upT;

    /**
     * 保温
     */
    private Boolean maintainT;

    /**
     * 降温
     */
    private Boolean downT;

    /**
     * 退货结束
     */
    private Boolean annealingEnd;

    /**
     * 吹扫冷却阀
     */
    private Boolean purgeCoolValue;

    /**
     * 排烟输出阀
     */
    private Boolean smokeExhaustOutputValue;

    /**
     * 插入时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
