package com.zju.springboot.db.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author 况祥彬
 * @date 2020/11/15 22:08
 **/
@Configuration
public class AtomikosDataSource {
    @Primary
    @Bean("primaryDataSource")

    @ConfigurationProperties(prefix = "primarydb")
    public AtomikosDataSourceBean primaryDataSource(){
        return new AtomikosDataSourceBean();
    }

    @Bean("secondaryDataSource")
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate primaryDataSource(@Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate secondaryDataSource( @Qualifier("secondaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
