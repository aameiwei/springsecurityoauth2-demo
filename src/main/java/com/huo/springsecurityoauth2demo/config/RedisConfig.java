package com.huo.springsecurityoauth2demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Author 小源同学
 * @Date 2022 01 16 00 26
 * @Describe Redis 配置类
 **/
@Configuration
public class RedisConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

//    @Bean
//    public TokenStore redisTokenStore(){
//        return new RedisTokenStore(redisConnectionFactory);
//    }
}
