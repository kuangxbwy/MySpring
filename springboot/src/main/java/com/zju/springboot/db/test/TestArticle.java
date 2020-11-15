package com.zju.springboot.db.test;

import com.zju.springboot.db.bean.Article;
import com.zju.springboot.db.service.MutilDataSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 况祥彬
 * @date 2020/11/15 22:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestArticle {
    @Autowired
    private MutilDataSourceService service;

    @Test
    public void test1(){
        Article article = new Article().builder().id(1L).author("kk").content("love").build();
        Article article1 = service.saveArticle(article);

    }
}
