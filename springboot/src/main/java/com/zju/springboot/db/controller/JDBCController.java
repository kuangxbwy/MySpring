package com.zju.springboot.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 况祥彬
 * @date 2020/11/14 23:22
 **/
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("select")
    public List<Map<String,Object>> select(){
            String sql="select * from role";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("add")
    public String add(){
        String sql="insert into role(ID,ROLE_NAME,ROLE_DESC) values(4,'kk','dd')";
        jdbcTemplate.update(sql);
        return "add-success";
    }

}
