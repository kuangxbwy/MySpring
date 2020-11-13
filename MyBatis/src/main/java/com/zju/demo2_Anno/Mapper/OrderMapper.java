package com.zju.demo2_Anno.Mapper;

import com.zju.demo2_Anno.Model.OrderModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.EAGER;

/**
 * @author 况祥彬
 * @date 2020/11/11 21:39
 *   /**
 * 注解开发
 *
 **/
public interface OrderMapper {



    @Select("select * from t_order;")
    @Results(id="orderMap" ,value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "create_name",property = "createName"),
            @Result(column = "up_time",property = "upTime"),
            //t_order表中拥有t_user表的外键user_id，所以用user_id来查userModel（OrderMapper中定义的UserModel属性）
            @Result(column = "user_id",property = "userModel",one = @One(select = "com.zju.demo2_Anno.Mapper.UserMapper.selectUserById",fetchType =EAGER ))//一对一立即加载
    })
    List<OrderModel> selectAll();


    @Select("select * from t_order WHERE id=#{userId}")
//    @ResultMap("orderMap")//todo 解决属性和数据库列名不一致问题 此时开启了自动映射所以无需
    OrderModel selectOrderById(@Param("userId") Integer id);

    @Select("SELECT a.id,a.user_id,a.create_time,a.up_time FROM t_order a WHERE a.id=#{id} ")
//    @ResultMap("orderMap")
    OrderModel select(Integer id);

    @Select("SELECT count(*) FROM t_order")
   // @ResultMap("orderMap")//不需要将数据库返回的数据和OrderModel进行绑定，所以不会出现名称不一致的情况
    int selectCount();

    @Update("UPDATE t_order SET  user_id=#{userId}  WHERE id=#{id} ")
//    @ResultMap("orderMap") 没有返回数据，更不会出现不一致情况
    void update(OrderModel user);


}
