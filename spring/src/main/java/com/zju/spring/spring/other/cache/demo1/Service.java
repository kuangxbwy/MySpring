package com.zju.spring.spring.other.cache.demo1;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/9 14:13
 **/
@Component
public class Service {
    @Cacheable(value = "cache1")
    public List<String> list(){
        System.out.println("文章列表。。。。");
        return Arrays.asList("java","c++","py");
    }
}
