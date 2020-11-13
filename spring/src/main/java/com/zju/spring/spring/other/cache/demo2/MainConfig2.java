package com.zju.spring.spring.other.cache.demo2;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.redisson.config.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author 况祥彬
 * @date 2020/11/9 15:52
 **/
@ComponentScan
@EnableCaching //开启spring cache功能
public class MainConfig2 {
    @Bean//@2：自定义spring中cache管理器，这个地方我们定义了一个redis类型的管理器，底层使用redis来作为缓存的存储介质。
    public CacheManager cacheManager() throws IOException {

        RedissonSpringCacheManager redissonSpringCacheManager = new RedissonSpringCacheManager(this.redissonClient());
        redissonSpringCacheManager.setCacheNames(Arrays.asList("cache1"));
        return redissonSpringCacheManager;

    }

    @Bean// @3：通过redis.yml配置文件来创建一个RedissonClient，用于和redis进行交互。

    private RedissonClient redissonClient() throws IOException {

        InputStream ras = MainConfig2.class.getResourceAsStream("/db/redis.yml");
        Config config = Config.fromYAML(ras);
        return Redisson.create(config);
    }
}
