package com.zju.spring.spring.AOP.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 况祥彬
 * @date 2020/11/8 20:37
 **/
public class test {
    @Test
    public void test() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
        ioc.register(Main.class);
        ioc.refresh();
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        System.out.println(bean.add(1, 2));
    }


    @Test
    public void test2(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(Main.class);
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        System.out.println(bean.add(1,2));
    }
}

