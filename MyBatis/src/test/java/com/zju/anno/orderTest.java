package com.zju.anno;

import com.zju.demo2_Anno.Mapper.OrderMapper;
import com.zju.demo2_Anno.Model.OrderModel;
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
 * @date 2020/11/11 23:20
 **/
public class orderTest {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private OrderMapper orderMapper;
    private  SqlSessionFactory factory;
    @Before
    public void before() throws IOException {
        inputStream= Resources.getResourceAsStream("Mybatis.xml");
        factory= new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=factory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
//    @Test
//    public  void  testSelectAll(){
//        List<OrderModel> orders = orderMapper.selectAll();
//        for (OrderModel order : orders) {
//            System.out.println(order);
//            //输出订单对应的用户信息
//            System.out.println(order.getUserModel());
//        }
//    }

    @Test
    public void testSelectOrderById(){
        System.out.println(orderMapper.selectOrderById(1));
    }

    @Test
    public void select(){
        System.out.println(orderMapper.select(1));
    }


    @Test
    public void selctCount(){
        System.out.println(orderMapper.selectCount());
    }


    @Test
    public void update(){
        OrderModel user = OrderModel.builder().id(1).userId(1).build();
        orderMapper.update(user);
    }
}
