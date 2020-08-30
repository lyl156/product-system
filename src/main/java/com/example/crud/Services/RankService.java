package com.example.crud.Services;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

public interface RankService {
    void addScore(String key, String value, double score);

    Set<String> getTopRank(String key, int start, int end);

    Set<ZSetOperations.TypedTuple<String>> getTopRankWithScore(String key, int start, int end);
}
