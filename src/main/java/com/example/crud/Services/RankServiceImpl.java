package com.example.crud.Services;

import com.example.crud.Repositories.Redis.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class RankServiceImpl implements RankService {
    Logger logger = LoggerFactory.getLogger("RankServiceImpl");
    private static String RANK_LIST = "rankList";
    private RedisRepository redisRepository;

    public RankServiceImpl(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    // value : product name
    // score : product price
    @Override
    public void addScore(String key, String value, double score) {
        redisRepository.add(RANK_LIST, value, score);
        logger.info("add in Redis element : %s, price : %d", value, score);
    }

    // return top 3 expensive product
    @Override
    public Set<String> getTopRank(String key, int start, int end) {
        return redisRepository.getTopElement(RANK_LIST, 0, 3);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> getTopRankWithScore(String key, int start, int end) {
        return redisRepository.getTopElementWithScore(RANK_LIST, 0, 3);
    }
}
