package com.zju.spring.spring.other.cache.demo1;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 况祥彬
 * @date 2020/11/9 14:16
 **/
@ComponentScan
@EnableCaching
public class MainConfig{
    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager ccmcm=new ConcurrentMapCacheManager("cache1");
        return ccmcm;
    }
}
