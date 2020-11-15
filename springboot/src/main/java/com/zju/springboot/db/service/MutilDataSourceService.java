package com.zju.springboot.db.service;

import com.zju.springboot.db.bean.Article;
import com.zju.springboot.db.dao.ArticleJDBCDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/15 21:50
 **/
@Service
public class MutilDataSourceService {
    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Resource
    JdbcTemplate primaryJdbcTemplate;

    @Resource
    JdbcTemplate secondaryJdbcTemplate;


    @Transactional
    public Article saveArticle(Article article) {

        articleJDBCDAO.save(article,primaryJdbcTemplate);

        articleJDBCDAO.save(article,secondaryJdbcTemplate);
        int i=10/0;
        return  article;
    }


    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id,primaryJdbcTemplate);
        articleJDBCDAO.deleteById(id,secondaryJdbcTemplate);
    }


    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article,primaryJdbcTemplate);
    }


    public Article getArticle(Long id) {
        return  articleJDBCDAO.findById(id,primaryJdbcTemplate);

    }

    public List<Article> getAll() {
        return articleJDBCDAO.findAll(primaryJdbcTemplate);
    }
}
