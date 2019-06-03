package com.exzone.config;

import com.exzone.shared.AuthToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisAuthConfig {
    @Value("${redis.auth.host}")
    private String redisHost;

    @Value("${redis.auth.port}")
    private Integer redisPort;

    @Value("${redis.auth.password}")
    private String redisPassword;

    @Bean(name = "redisAuthConnectionFactory")
    JedisConnectionFactory redisAuthConnectionFactory() {
        return RedisConfigUtil.getJedisConnectionFactory(redisHost, redisPort, redisPassword);
    }

    @Bean(name = "redisAuthTemplate")
    RedisTemplate<String, AuthToken> redisAuthTemplate() throws Exception {
        final RedisTemplate<String, AuthToken> template = new RedisTemplate<>();
        template.setConnectionFactory(redisAuthConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(AuthToken.class));
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(AuthToken.class));
        return template;
    }
}
