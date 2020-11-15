package com.zju.springboot.demo1.test;

import com.zju.springboot.demo1.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 况祥彬
 * @date 2020/11/14 18:37
 **/

@RunWith(SpringRunner.class)//使用Spring的Runner 不然null
@SpringBootTest
public class personTest {
    @Autowired
    private Person person;

    @Test
    public void test(){
        System.out.println(person);
    }
}
