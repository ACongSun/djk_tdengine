package com.djk.TDengineData.controller;

import com.djk.TDengineData.service.RewindRollService;
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

/**
 * @author 孙少聪
 * @Date 2023/2/27 17:39:43
 * @Description 重卷机
 */
@Slf4j
@RestController
@EnableScheduling
@RequestMapping("/rewindRoll")
public class RewindRollController {

    @Resource
    private RewindRollService rewindRollService;


    @Scheduled(fixedRateString = "${taskTime.rewindRoll}")
    @Async("asyncServiceExecutor")
    @GetMapping()
    public String rewindRoll(){
        String sql = "select * from t_8e6f17d0928e11ed8fbe65289e32d77e where ts > now - 5s;";
        String isSucc = rewindRollService.saveBatchRewindRoll(sql);
        log.info("rewindRoll" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @GetMapping("/historyRange")
    public ArrayList<Object> historyRange(String sql, String type){
        ArrayList<Object> arrayList = rewindRollService.getHistoryList(sql, type);
        log.info("重卷机历史数据" + LocalDateTime.now());
        return arrayList;
    }



}
