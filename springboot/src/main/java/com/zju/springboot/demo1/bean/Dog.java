package com.zju.springboot.demo1.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 况祥彬
 * @date 2020/11/14 18:31
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Component //注册bean
public class Dog {
    @Value("kk")
    private String name;
   @Value("18")
   private Integer age;
}