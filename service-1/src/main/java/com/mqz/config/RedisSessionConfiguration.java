package com.mqz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author mqz
 * @description
 * @since 2020/6/24
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1900)
public class RedisSessionConfiguration {
}
