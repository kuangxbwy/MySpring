package com.zju.demo3;

import com.zju.demo3.mapper.UserMapper;
import com.zju.demo3.model.UserModel;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 况祥彬
 * @date 2020/11/12 12:57
 **/
@Slf4j
public class test1 {
    // java.io.InputStream;
    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;
    private UserMapper userMapper;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("Mybatis.xml");
        //2.获取SqlSessionFactory
         factory = new SqlSessionFactoryBuilder().build(in);
//        //3.获取SqlSession对象
//        sqlSession = factory.openSession(true);
//        //4.获取dao的代理对象
//        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testGetList1(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","张学友");
        List<UserModel> userList = userMapper.getList1(map);
        log.info("{}",userList);
    }

    @Test
    public void testtestGetList3(){
        List<UserModel> list = userMapper.getList3("k");
        log.info("{}",list);
    }

    @Test
    public void testInsert(){
        ArrayList<UserModel> list = new ArrayList<>();
        list.add(UserModel.builder().name("kk").id(4).age(18).build());
        list.add(UserModel.builder().name("kk").id(5).age(18).build());
        list.add(UserModel.builder().name("kk").id(6).age(18).build());
        System.out.println(userMapper.insertBatch(list));
    }

    @Test
    public void testDelete(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);

        userMapper.delete(1);
    }


    //todo=====================cache==================
    @Test
    public void level1CacheTest1(){
        List<UserModel> list1 = userMapper.getList1(null);
        List<UserModel> list2 = userMapper.getList1(null);
        log.info("{}",list1);
        log.info("{}",list2);
    }
    @Test
    public void level1CacheTest2(){
        List<UserModel> list1 = userMapper.getList1(null);
        log.info("{}",list1);
        //调用clearCache方法清理当前SqlSession中的缓存
        sqlSession.clearCache();
        List<UserModel> list2 = userMapper.getList1(null);
        log.info("{}",list2);
    }

    @Test
    public void level2CacheTest1() throws IOException {
        for (int i = 0; i < 2; i++) {
            try (SqlSession sqlSession = factory.openSession(true)) {
                UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                List<UserModel> userModelList1 = mapper.getList1(null);
                log.info("{}", userModelList1);
            }
        }
    }

}
