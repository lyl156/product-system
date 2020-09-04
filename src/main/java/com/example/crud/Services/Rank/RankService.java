package com.example.crud.Services.Rank;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

public interface RankService {
    void addScore(String value, double score);

    void removeScore(String value);

    Long removeAllScore();

    Set<String> getTopRank();

    Set<ZSetOperations.TypedTuple<String>> getTopRankWithScore(String key, int start, int end);
}
