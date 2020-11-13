package com.zju.demo1;

import com.zju.demo1.dto.UserFindDto;
import com.zju.demo1.mapper.UserMapper;
import com.zju.demo1.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 况祥彬
 * @date 2020/11/10 23:16
 **/
@Slf4j
public class testUser {

    // java.io.InputStream;
    private InputStream in;
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
    //1.读取配置文件，生成字节输入流
    in = Resources.getResourceAsStream("Mybatis.xml");
    //2.获取SqlSessionFactory
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
    //3.获取SqlSession对象
    sqlSession = factory.openSession(true);
    //4.获取dao的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
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
    public void getByName(){
            UserModel model = userMapper.getByName("kk");
            System.out.println(model);
    }

    @Test
    public void getByMap() {

            Map<String, Object> map = new HashMap<>();
            map.put("id", 1L);
            map.put("name", "张学友");
            List<UserModel> userModelList = userMapper.getByMap(map);
            userModelList.forEach(item -> {
                log.info("{}", item);
            });
        }

    @Test
    public void getByJavaBean(){
        UserFindDto build = UserFindDto.builder().userId(1L).userName("kk").build();
        List<UserModel> listByUserFindDto = userMapper.getListByUserFindDto(build);
        listByUserFindDto.forEach(item->{
            log.info("{}",item);
        });
    }

    @Test
    public void getByIdOrName(){
        UserModel model = userMapper.getByIdOrName(1L, "kk");
        System.out.println(model);
    }

}
