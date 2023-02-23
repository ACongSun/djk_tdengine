package com.djk.TDengineData.controller;

import com.alibaba.fastjson.JSON;
import com.djk.TDengineData.dto.MachineTypeEnum;
import com.djk.TDengineData.service.OneCastrollService;
import com.djk.TDengineData.utils.TDengineData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 孙少聪
 * @Date 2023/2/21 15:32:56
 * @Description 获取铸轧机的数据
 */
@Slf4j
@RestController
@EnableScheduling
@RequestMapping("/oneCastRoll")
public class OneCastRollController {

    @Resource
    private OneCastrollService oneCastrollService;

    @Scheduled(fixedRateString = "${taskTime.oneCast}")
    @Async("asyncServiceExecutor")
    @GetMapping("/oneCast")
    public String oneCast(){
        String sql = "SELECT * FROM t_3d8761c0928d11ed8fbe65289e32d77e where ts > now - 5s;";
        String isSucc = oneCastrollService.saveBatchOneCast(sql);
        log.info(isSucc + LocalDateTime.now());
        return isSucc;
    }

    //@Scheduled(fixedRateString = "${taskTime.twoCast}")
    //@Async("asyncServiceExecutor")
    //@GetMapping("/twoCast")
    //public String twoCast(){
    //    System.out.println("twoCast" + LocalDateTime.now());
    //    return null;
    //}
    //
    //@Scheduled(fixedRateString = "${taskTime.threeCast}")
    //@Async("asyncServiceExecutor")
    //@GetMapping("/threeCast")
    //public String threeCast(){
    //    System.out.println("threeCast" + LocalDateTime.now());
    //    return null;
    //}
    //
    //@Scheduled(fixedRateString = "${taskTime.fourCast}")
    //@Async("asyncServiceExecutor")
    //@GetMapping("/fourCast")
    //public String fourCast(){
    //    System.out.println("fourCast" + LocalDateTime.now());
    //    return null;
    //}
    //
    //@Scheduled(fixedRateString = "${taskTime.fiveCast}")
    //@Async("asyncServiceExecutor")
    //@GetMapping("/fiveCast")
    //public String fiveCast(){
    //    System.out.println("fiveCast" + LocalDateTime.now());
    //    return null;
    //}
}
