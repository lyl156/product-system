package com.example.crud;

import com.example.crud.Services.Rank.RankService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CleanRedis implements DisposableBean {
    Logger logger = LoggerFactory.getLogger(CleanRedis.class);
    private final RankService rankService;

    public CleanRedis(RankService rankService) {
        this.rankService = rankService;
    }

    @Override
    public void destroy() throws Exception {
        Long cnt = rankService.removeAllScore();
        logger.info("clean " + cnt + "item in Redis");
    }
}
