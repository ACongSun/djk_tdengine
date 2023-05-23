package com.djk.TDengineData.controller;

import com.djk.TDengineData.domain.OneCastRoll;
import com.djk.TDengineData.service.OneCastrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙少聪
 * @Date 2023/2/21 15:32:56
 * @Description 获取铸轧机的数据
 */
@Slf4j
@RestController
@EnableScheduling
@RequestMapping("/castRoll")
public class OneCastRollController {

    @Resource
    private OneCastrollService oneCastrollService;

    @Scheduled(fixedRateString = "${taskTime.oneCast}")
    @Async("asyncServiceExecutor")
    @GetMapping("/oneCast")
    public String oneCast(){
        //26f7a000928d11ed8fbe65289e32d77e  一号铸轧机
        String sql = "SELECT * FROM t_26f7a000928d11ed8fbe65289e32d77e where ts > now - 5s;";
        String isSucc = oneCastrollService.saveBatchOneCast(sql, 1);
        log.info("oneCast" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.twoCast}")
    @Async("asyncServiceExecutor")
    @GetMapping("/twoCast")
    public String twoCast(){
        //t_31daa490928d11ed8fbe65289e32d77e  二号铸轧机
        String sql = "SELECT * FROM t_31daa490928d11ed8fbe65289e32d77e where ts > now - 5s;";
        String isSucc = oneCastrollService.saveBatchOneCast(sql, 2);
        log.info("twoCast" + isSucc + LocalDateTime.now());
        return isSucc;
    }


    @Scheduled(fixedRateString = "${taskTime.threeCast}")
    @Async("asyncServiceExecutor")
    @GetMapping("/threeCast")
    public String threeCast(){
        //t_3d8761c0928d11ed8fbe65289e32d77e 三号铸轧机
        String sql = "SELECT * FROM t_3d8761c0928d11ed8fbe65289e32d77e where ts > now - 5s;";
        String isSucc = oneCastrollService.saveBatchOneCast(sql, 3);
        log.info("threeCast" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.fourCast}")
    @Async("asyncServiceExecutor")
    @GetMapping("/fourCast")
    public String fourCast(){
        //t_48d24fe0928d11ed8fbe65289e32d77e 四号铸轧机
        String sql = "SELECT * FROM t_48d24fe0928d11ed8fbe65289e32d77e where ts > now - 5s;";
        String isSucc = oneCastrollService.saveBatchOneCast(sql, 4);
        log.info("fourCast" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.fiveCast}")
    @Async("asyncServiceExecutor")
    @GetMapping("/fiveCast")
    public String fiveCast(){
        //t_58a64890928d11ed8fbe65289e32d77e 五号铸轧机
        String sql = "SELECT * FROM t_58a64890928d11ed8fbe65289e32d77e where ts > now - 5s;";
        String isSucc = oneCastrollService.saveBatchOneCast(sql, 5);
        log.info("fiveCast" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @GetMapping("/historyRange")
    public ArrayList<Object> historyRange(String sql, String type){
        System.out.println("打印type"+type);
        ArrayList<Object> arrayList = oneCastrollService.getHistoryList(sql, type);
        log.info("铸轧机历史数据" + LocalDateTime.now());
        return arrayList;
    }

}
