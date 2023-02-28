package com.djk.TDengineData.utils;

public enum MachineTypeEnum {

    //  铸轧机
    COLSCASTROLL,
    //  重卷机
    REWINDROLL,
    // 退火炉
    QUENCHINGFURNACE;


    /**
     * 返回每个机器的列数据，务必对应顺序
     * @param machineType
     */
    public static String[] getColsCastRoll(MachineTypeEnum machineType) {
        switch (machineType)
        {
            case COLSCASTROLL:
                return new String[]{"ts", "upRollMontorA", "upRollMontorLineV",
                        "downRollMontorA", "downRollMontorLineV",
                        "pumpA", "pumpF", "RollA", "RollV", "inWaterT", "inWaterFN",
                        "upRollWaterFN", "upRollWaterT", "upRollFlow", "downRollWaterFN",
                        "downRollWaterT", "downRollFlow", "operationPreloadForce", "TransPreloadForce",
                        "rollTension", "rollDiameter", "tiWireSpeed", "withMaterialSpeed"};
            case REWINDROLL:
                return new String[]{"ts","machineColsV", "openScrollD","rollWindD","unitTension","actualTension","openRollA","rollWindA","stripL","stripW","pressureStatonT"
                        ,"materialWidth","meteriaThicness","discShearOperatingSideA","discShearDriveSideA","crusherOperatingSideA","driveSideCrusherA"
                        , "openRollThinOilT","rollOutThinOilT"};
            case QUENCHINGFURNACE:
                return new String[]{"ts", "zoneOneT", "zoneTwoT", "zoneThreeT", "meterialT",
                        "zoneOneHotOutput", "zoneTwoHotOutput", "zoneThreeHotOutput", "setT",
                        "desiredT", "exhaustFanSetF", "inFanSetF", "controlType", "materialControlT",
                        "warnSetT", "crusherOperatingSideA", "furnaceDoorCoolWater", "funCoolWater",
                        "returnWaterHighT", "coolWaterUpLimit", "compressedAirOneLowPressure",
                        "compressedAirTwoLowPressure", "upT", "maintainT", "downT", "annealingEnd",
                        "purgeCoolValue", "smokeExhaustOutputValue"};
            default:
                return new String[1];
        }
    }

}
