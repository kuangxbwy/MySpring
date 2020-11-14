package tx.demo1;

import tx.JdbcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 况祥彬
 * @date 2020/11/9 19:52
 **/
@EnableTransactionManagement //开启spring事务管理功能
@Configuration //指定当前类是一个spring配置类
@ComponentScan //开启bean扫描注册
@PropertySource("/db/jdbc.properties")
@Import(JdbcConfig.class)
public class MainConfig {
}

