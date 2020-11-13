package com.zju.spring.spring.tx.propagation;

import com.zju.spring.spring.tx.JdbcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 况祥彬
 * @date 2020/11/10 19:36
 **/
@EnableTransactionManagement
@ComponentScan
@Configuration
@Import(JdbcConfig.class)
@PropertySource("/db/jdbc.properties")
public class MainConfig {
}
