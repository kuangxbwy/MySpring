package com.zju.spring.spring.IOC.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 况祥彬
 * @date 2020/11/10 12:48
 **/
public class Test {
    @org.junit.Test
    public void test(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        for (String s : ioc.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }

}
