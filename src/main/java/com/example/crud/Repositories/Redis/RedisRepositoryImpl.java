package com.example.crud.Repositories.Redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private RedisTemplate redisTemplate;

    public RedisRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void add(String key, String value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    @Override
    public Long remove(String key, String value) {
        //return number of removed elements
        return redisTemplate.opsForZSet().remove(key, value);
    }

    @Override
    public Long size(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

    @Override
    public Double getElementScore(String key, String value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    @Override
    public Long getReverseRank(String key, String value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    @Override
    public Set<String> getTopElement(String key, int start, int end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> getTopElementWithScore(String key, int start, int end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
    }
}
