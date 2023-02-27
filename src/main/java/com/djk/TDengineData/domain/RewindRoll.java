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
 * @TableName rewind_roll
 */
@TableName(value ="rewind_roll")
@Data
public class RewindRoll implements Serializable {
    /**
     * ts
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date ts;

    /**
     * 机列速度
     */
    private Double machineColsV;

    /**
     * 开卷卷径
     */
    private Double openScrollD;

    /**
     * 卷取卷径
     */
    private Double rollWindD;

    /**
     * 单位张力
     */
    private Double unitTension;

    /**
     * 实际张力
     */
    private Double actualTension;

    /**
     * 开卷机电流
     */
    private Double openRollA;

    /**
     * 卷取机电流
     */
    private Double rollWindA;

    /**
     * 带材长度
     */
    private Double stripL;

    /**
     * 带材重量
     */
    private Double stripW;

    /**
     * 液压站温度
     */
    private Double pressureStatonT;

    /**
     * 来料宽度
     */
    private Double materialWidth;

    /**
     * 来料厚度
     */
    private Double meteriaThicness;

    /**
     * 圆盘剪操作侧电流
     */
    private Double discShearOperatingSideA;

    /**
     * 圆盘剪传动侧电流
     */
    private Double discShearDriveSideA;

    /**
     * 破碎机操作侧电流
     */
    private Double crusherOperatingSideA;

    /**
     * 破碎机传动侧电流
     */
    private Double driveSideCrusherA;

    /**
     * 开卷稀油温度
     */
    private Double openRollThinOilT;

    /**
     * 卷取稀油温度
     */
    private Double rollOutThinOilT;

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
