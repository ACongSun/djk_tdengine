package com.djk.TDengineData.dto;

public enum MachineTypeEnum {
    //  1#铸轧机
    COLSCASTROLL1;

    /**
     * 返回每个机器的列数据，务必对应顺序
     * @param machineType
     */
    public static String[] getColsCastRoll(MachineTypeEnum machineType) {
        switch (machineType)
        {
            case COLSCASTROLL1:
                return new String[]{"ts", "upRollMontorA", "upRollMontorLineV",
                        "downRollMontorA", "downRollMontorLineV",
                        "pumpA", "pumpF", "RollA", "RollV", "inWaterT", "inWaterFN",
                        "upRollWaterFN", "upRollWaterT", "upRollFlow", "downRollWaterFN",
                        "downRollWaterT", "downRollFlow", "operationPreloadForce", "TransPreloadForce",
                        "rollTension", "rollDiameter", "tiWireSpeed", "withMaterialSpeed"};
            default:
                return new String[1];
        }
    }

}
