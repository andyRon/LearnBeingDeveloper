package com.andyron.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Andy Ron
 */
@Service  // 类上加入@Service，表明这是一个受Spring管理的JavaBean对象
public class RedisService {

    @Resource  // 在RedisService类内注入RedisTemplate，用于对Redis缓存进行操作
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public Object get(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }
}
