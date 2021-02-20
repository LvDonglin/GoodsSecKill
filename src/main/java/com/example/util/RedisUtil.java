package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.util
 * @ClassName: RedisUtil
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 13:19
 * @Version: 1.0
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 递增
     * @param key 键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }
    /**
     * 递减
     * @param key 键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        System.out.println("Redis: "+key+"当前库存为"+redisTemplate.opsForValue().get(key));
        return redisTemplate.opsForValue().increment(key,-delta);
    }
}
