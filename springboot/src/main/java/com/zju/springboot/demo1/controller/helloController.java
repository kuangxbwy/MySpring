package com.zju.springboot.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 况祥彬
 * @date 2020/11/14 17:16
 **/
@RestController
public class helloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Fighting kk";
    }
}
