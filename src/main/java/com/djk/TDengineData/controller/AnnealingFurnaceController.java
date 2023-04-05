package com.djk.TDengineData.controller;

import com.djk.TDengineData.service.AnnealingFurnaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author 孙少聪
 * @Date 2023/2/28 10:01:07
 * @Description 退火炉
 */
@Slf4j
@RestController
@RequestMapping("/annealingFurnace")
@EnableScheduling
public class AnnealingFurnaceController {

    @Resource
    private AnnealingFurnaceService annealingFurnaceService;

    @Scheduled(fixedRateString = "${taskTime.oneAnneaFur}")
    @Async("asyncServiceExecutor")
    @GetMapping("/oneAnneaFur")
    public String annealingFurnaceOne(){
        String sql = "select * from t_26b106d0a62511ed8b62ff846936488a where ts > now - 5s;";
        String isSucc = annealingFurnaceService.saveBatchoneAnneaFur(sql, 1);
        log.info("oneAnneaFur" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.twoAnneaFur}")
    @Async("asyncServiceExecutor")
    @GetMapping("/twoAnneaFur")
    public String annealingFurnaceTwo(){
        String sql = "select * from t_2ed846c0a62511ed8b62ff846936488a where ts > now - 5s;";
        String isSucc = annealingFurnaceService.saveBatchoneAnneaFur(sql, 2);
        log.info("twoAnneaFur" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.threeAnneaFur}")
    @Async("asyncServiceExecutor")
    @GetMapping("/threeAnneaFur")
    public String annealingFurnaceThree(){
        String sql = "select * from t_37e21e80a62511ed8b62ff846936488a where ts > now - 5s;";
        String isSucc = annealingFurnaceService.saveBatchoneAnneaFur(sql, 3);
        log.info("threeAnneaFur" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.fourAnneaFur}")
    @Async("asyncServiceExecutor")
    @GetMapping("/fourAnneaFur")
    public String annealingFurnaceFour(){
        String sql = "select * from t_4085e170a62511ed8b62ff846936488a where ts > now - 5s;";
        String isSucc = annealingFurnaceService.saveBatchoneAnneaFur(sql, 4);
        log.info("fourAnneaFur" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.fiveAnneaFur}")
    @Async("asyncServiceExecutor")
    @GetMapping("/fiveAnneaFur")
    public String annealingFurnaceFive(){
        String sql = "select * from t_48b42640a62511ed8b62ff846936488a where ts > now - 5s;";
        String isSucc = annealingFurnaceService.saveBatchoneAnneaFur(sql, 5);
        log.info("fiveAnneaFur" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.sixAnneaFur}")
    @Async("asyncServiceExecutor")
    @GetMapping("/sixAnneaFur")
    public String annealingFurnaceSix(){
        String sql = "select * from t_51af30f0a62511ed8b62ff846936488a where ts > now - 5s;";
        String isSucc = annealingFurnaceService.saveBatchoneAnneaFur(sql, 6);
        log.info("sixAnneaFur" + isSucc + LocalDateTime.now());
        return isSucc;
    }

    @Scheduled(fixedRateString = "${taskTime.sevenAnneaFur}")
    @Async("asyncServiceExecutor")
    @GetMapping("/sevenAnneaFur")
    public String annealingFurnaceSeven(){
        String sql = "select * from t_60cc35b0a62511ed8b62ff846936488a where ts > now - 5s;";
        String isSucc = annealingFurnaceService.saveBatchoneAnneaFur(sql, 7);
        log.info("sevenAnneaFur" + isSucc + LocalDateTime.now());
        return isSucc;
    }
}
