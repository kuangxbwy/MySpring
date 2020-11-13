package com.zju.demo2_Anno.Mapper;

import com.zju.demo1.dto.UserFindDto;
import com.zju.demo2_Anno.Model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author 况祥彬
 * @date 2020/11/11 21:48
 * 这里的Model属性名和数据库列名是一致的，所以不用ResultMap来解决不一致问题
 **/
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{userId} ")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
//    @Select("select * from user where username like #{username} ")
    @Select("select * from user where username like '%${value}%' ")
    List<User> findUserByName(String username);

    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user ")
    int findTotalUser();

    @Select("select * from user where id=#{id} or username=#{username}")
    List<User> findByMap(Map<String,Object> map);

    @Select("select * from user where id=#{id} or username=#{username}")
    List<User> findByUserFindDto(UserFindDto userFindDto);


    @Select("select * from user where id=#{userId} or username=#{userName}")
//    @Select("select * from user where id=#{id} or username=#{name}")
    List<User> findByIdOrName(@Param("userId") int id, @Param("userName") String name);
}
