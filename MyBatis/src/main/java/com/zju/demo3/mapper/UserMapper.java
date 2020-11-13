package com.zju.demo3.mapper;

import com.zju.demo3.model.UserModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 况祥彬
 * @date 2020/11/12 11:46
 **/
public interface UserMapper {

    List<UserModel> getList1(Map<String, Object> paramMap);


//    @Select("select * from user_dynamic WHERE NAME LIKE concat('%',#{namesxaasc},'%');")
    @Select("select * from user_dynamic WHERE NAME LIKE concat('%','${value}','%');")
//    @Select("select * from user_dynamic WHERE NAME LIKE '%${value}%';")
    List<UserModel> getList3(String name);
    int insertBatch(List<UserModel> userModelList);
//    @Delete("DELETE FROM user_dynamic WHERE id=#{id} ")
    void delete(Integer id);
}
