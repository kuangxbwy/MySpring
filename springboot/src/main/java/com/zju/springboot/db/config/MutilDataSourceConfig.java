package com.zju.springboot.db.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 况祥彬
 * @date 2020/11/15 21:42
 **/
@Configuration
public class MutilDataSourceConfig {

//    @Primary
//    @Bean(name = "primaryDataSource")
//    @Qualifier("primaryDataSource")
//    @ConfigurationProperties(prefix="spring.datasource.primary")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "secondaryDataSource")
//    @Qualifier("secondaryDataSource")
//    @ConfigurationProperties(prefix="spring.datasource.secondary")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name="primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate (
//            @Qualifier("primaryDataSource") DataSource dataSource ) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    @Bean(name="secondaryJdbcTemplate")
//    public JdbcTemplate secondaryJdbcTemplate(
//            @Qualifier("secondaryDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
}
