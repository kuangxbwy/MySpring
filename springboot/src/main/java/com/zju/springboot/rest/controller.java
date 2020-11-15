package com.zju.springboot.rest;

import com.zju.springboot.db.bean.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author 况祥彬
 * @date 2020/11/15 11:09
 **/
@Slf4j
@RestController
public class controller {

    @GetMapping("/articles/{id}")
    public AjaxResponse get(@PathVariable("id") long id){

        Article article = Article.builder().id(id).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article);
    }

    @PostMapping("/articles")
    public AjaxResponse save(@RequestBody Article article,
                             @RequestHeader String a){
        log.info("save: "+article);
        return AjaxResponse.success();
    }


}
