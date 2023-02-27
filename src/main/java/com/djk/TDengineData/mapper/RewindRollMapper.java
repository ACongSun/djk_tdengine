package com.djk.TDengineData.mapper;

import com.djk.TDengineData.domain.RewindRoll;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Admin
* @description 针对表【rewind_roll】的数据库操作Mapper
* @createDate 2023-02-27 17:38:01
* @Entity com.djk.TDengineData.domain.RewindRoll
*/
@Mapper
public interface RewindRollMapper extends BaseMapper<RewindRoll> {
    /**
     * 重卷机
     * 批量插入 存在更新 不存在插入
     * @return
     */
    Boolean saveBatchRewindRoll(List<RewindRoll> list);
}




