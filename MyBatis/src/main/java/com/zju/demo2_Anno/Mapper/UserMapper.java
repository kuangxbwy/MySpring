package com.zju.demo2_Anno.Mapper;

import com.zju.demo2_Anno.Model.UserModel;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/11 23:01
 **/
public interface UserMapper {


    @Select("SELECT * FROM  t_user ")
    @Results(id="userMap",value = {
         @Result(id = true,column = "id",property = "id"),
         @Result(column = "name",property = "name"),
    })
    List<UserModel> selectAll();




    @Select("select * from t_user WHERE id=#{id} ")
    @ResultMap("userMap")
    UserModel selectUserById(Integer id);


}
