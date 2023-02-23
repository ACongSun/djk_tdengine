package com.djk.TDengineData.mapper;

import com.djk.TDengineData.domain.OneCastRoll;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Admin
* @description 针对表【one_castroll】的数据库操作Mapper
* @createDate 2023-02-22 16:34:34
* @Entity com.djk.TDengineData.domain.OneCastRoll
*/
@Mapper
public interface OneCastrollMapper extends BaseMapper<OneCastRoll> {

    /**
     * 批量插入 存在更新 不存在插入
     * @return
     */
    Boolean saveBatchOneCast(List<OneCastRoll> list);
}




