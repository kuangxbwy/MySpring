package com.zju.anno;

import com.zju.demo2_Anno.Mapper.IUserDao;
import com.zju.demo2_Anno.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/11 21:40
 **/
public class DaoTest {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private IUserDao userDao;
    @Before
    public void before() throws IOException {
        inputStream= Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }




    @Test
    public void findAll(){
        System.out.println(userDao.findAll());
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("北京市昌平区");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(48);
        user.setUsername("kk");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }


    @Test
    public void testDelete() {
        userDao.deleteUser(51);
    }



    @Test
    public void testFindOne() {
        User user = userDao.findById(48);
        System.out.println(user);
    }


    @Test
    public void testFindByName() {
//        List<User> users = userDao.findUserByName("%mybatis%");
        List<User> users = userDao.findUserByName("mybatis");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotalUser();
        System.out.println(total);
    }

//    @Test
//    public  void findByUserFindDto(){
//        UserFindDto userFindDto = UserFindDto.builder().id(41).username("老王").build();
//        List<User> dto = userDao.findByUserFindDto(userFindDto);
//        for (User user : dto) {
//            System.out.println(user);
//        }
//    }

    @Test
    public  void  findByIdOrName(){
        List<User> userDaoByIdOrName = userDao.findByIdOrName(41, "老王");
        for (User user : userDaoByIdOrName) {
            System.out.println(user);
        }
    }

}
