package com.example.crud.Repositories.Redis;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

public interface RedisRepository {
    //z_set operation
    //https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/core/ZSetOperations.html#remove-K-java.lang.Object...-
    void add(String key, String value, double score);

    Long remove(String key, String value);

    Long removeAll(String key);

    Long size(String key);

    Double getElementScore(String key, String value);

    //single element : higher score , higher rank
    Long getReverseRank(String key, String value);

    Set<String> getTopElement(String key, int start, int end);

    Set<ZSetOperations.TypedTuple<String>> getTopElementWithScore(String key, int start, int end);


}
