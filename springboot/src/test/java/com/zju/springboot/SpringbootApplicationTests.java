package com.zju.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootApplicationTests {
	@Autowired
	DataSource dataSource;

	@Test
	public void testJdbc() throws SQLException {
		//看一下默认数据源
		System.out.println(dataSource.getClass());
	//获得连接
	Connection connection =   dataSource.getConnection();
		System.out.println(connection);
	//关闭连接
		connection.close();
}

}
