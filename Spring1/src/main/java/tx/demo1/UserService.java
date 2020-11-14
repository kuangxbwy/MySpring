package tx.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 况祥彬
 * @date 2020/11/9 20:00
 **/
@Component
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Transactional
    public int insertBeach(String ...names){
        int result=0;
        for (String name : names) {
//             result += jdbcTemplate.update("INSERT INTO t_user(name) VALUES(?) ", name);
             result += jdbcTemplate.update("INSERT INTO t_user(name) VALUES (?)", name);
        }
        return result;
    }

    public List<Map<String,Object>> selectList(){
        return jdbcTemplate.queryForList("SELECT * FROM t_user");
    }
}
