package com.zju.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class}*/)
//@PropertySource(value = {"classpath:jdbc.properties"})
//@ImportResource(value = {"classpath:spring.xml"})
public class SpringbootApplication {
///
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
