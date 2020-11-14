package tx.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 况祥彬
 * @date 2020/11/10 19:35
 **/
@Component
public class Service1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public void required(String name){
        this.jdbcTemplate.update("INSERT INTO user1(name) VALUES (?)",name);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requires_new(String name) {
        this.jdbcTemplate.update("insert into user1(name) VALUES (?)", name);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nested(String name) {
        this.jdbcTemplate.update("insert into user1(name) VALUES (?)", name);
    }
}
