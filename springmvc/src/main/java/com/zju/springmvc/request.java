package com.zju.springmvc;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 况祥彬
 * @date 2020/11/3 18:48
 **/
@RestController
public class request {

    //   localhost:8080/user/kk
    @RequestMapping(value = "/user1/{username}")
    public String testPathVariable(@PathVariable(value = "username") String username, HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getQueryString());
        System.out.println(request.getSession());
        System.out.println(request.getCookies());
        System.out.println(request.getContextPath());
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getMethod());
        return "user" + username;
    }

    //  ?id=1&name=kk
    @RequestMapping(value = "/user2")
    public ModelAndView testRequestParam(@RequestParam(value = "id" ,required = false,defaultValue ="0") int id, @RequestParam(value = "name") String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("kk");
        mv.addObject("id",id);
        mv.addObject("msg","返回值是："+name);
        return mv;
    }


    // RequestBody和responseBody 对应 httpEntity和 responseEntity
    @RequestMapping(value = "/user3")
    public String testRequestBody(@RequestBody String name){
        return name;
    }


    @RequestMapping(value="/user4") //当请求头中没有Accept-Language就会报错
    public String testRequestHeader(@RequestHeader(value="Accept-Language") String al){
        System.out.println("testRequestHeader - Accept-Language："+al);
        return "success";
    }

    @RequestMapping("/user5")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return "success";
    }


}
