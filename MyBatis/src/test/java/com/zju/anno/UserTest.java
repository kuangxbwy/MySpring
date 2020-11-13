package com.zju.anno;

import com.zju.demo2_Anno.Mapper.OrderMapper;
import com.zju.demo2_Anno.Mapper.UserMapper;
import com.zju.demo2_Anno.Model.UserModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/11 23:09
 **/
public class UserTest {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private OrderMapper orderMapper;
    private UserMapper userMapper;
    @Before
    public void before() throws IOException {
        inputStream= Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=factory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void testSelectAll(){
        List<UserModel> userModels = userMapper.selectAll();
        for (UserModel userModel : userModels) {
            System.out.println(userModel);
        }
    }

    @Test
    public void test(){
        System.out.println(userMapper.selectUserById(1));
    }
}
