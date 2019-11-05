package com.springBootTutorial.config;

import com.springBootTutorial.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//@Configuration
public class RedisConfig {

    /*JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    RedisTemplate<String, User> redisTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }*/

}
