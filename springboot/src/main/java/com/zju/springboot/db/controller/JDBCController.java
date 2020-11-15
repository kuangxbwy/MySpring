package com.zju.springboot.db.controller;

import com.zju.springboot.db.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("select1/{id}")
    public Role select1(@PathVariable(value = "id") int id){
       Role role = jdbcTemplate.queryForObject("select * from role WHERE  id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Role.class));
        System.out.println(role);
        return role;
    }

    @GetMapping("selectAll")
    public List<Role> selectAll(){
        List<Role> roles = jdbcTemplate.query("select * from role", new BeanPropertyRowMapper<>(Role.class));

        return roles;
    }


    @GetMapping("add")
    public String add(){
        String sql="insert into role(ID,ROLE_NAME,ROLE_DESC) values(5,'kk','dd')";
        jdbcTemplate.update(sql);
//        int a=10/0;
        return "add-success";
    }

}
