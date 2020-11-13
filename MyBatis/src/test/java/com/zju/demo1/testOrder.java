package com.zju.demo1;

import com.zju.demo1.mapper.OrderMapper;
import com.zju.demo1.model.OrderModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 况祥彬
 * @date 2020/11/11 18:28
 **/
@Slf4j
public class testOrder {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private OrderMapper orderMapper;
    @Before
    public void before() throws IOException {
        inputStream= Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=factory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void getById(){
        OrderModel byId = orderMapper.getById(1);
        System.out.println(byId);
    }
    @Test
    public void  getById1(){
        OrderModel byId1 = orderMapper.getById1(1);
        System.out.println(byId1);
    }
    @Test
    public void getById2(){
        System.out.println(orderMapper.getById2(1));
    }


}
