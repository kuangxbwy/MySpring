package com.zju.demo1.mapper;

import com.zju.demo1.dto.UserFindDto;
import com.zju.demo1.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author 况祥彬
 * @date 2020/11/10 23:09
 **/
public interface UserMapper {
    /**
     * 通过name查询
     *
     * @param name
     * @return
     */
    UserModel getByName(String name);

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<UserModel> getByMap(Map<String, Object> map);

    /**
     * 通过UserFindDto进行查询
     *
     * @param userFindDto
     * @return
     */
    List<UserModel> getListByUserFindDto(UserFindDto userFindDto);

    /**
     * 通过id或者name查询
     *
     * @param id
     * @param name
     * @return
     */
    UserModel getByIdOrName(@Param("userId") Long id, @Param("userName") String name);

    /**
     * 查询用户id列表
     *
     * @param idCollection
     * @return
     */
    List<UserModel> getListByIdCollection(Collection<Long> idCollection);

    /**
     * 查询用户id列表
     *
     * @param idList
     * @return
     */
    List<UserModel> getListByIdList(List<Long> idList);

    /**
     * 查询用户id列表
     *
     * @param idArray
     * @return
     */
    List<UserModel> getListByIdArray(Long[] idArray);

    void getList(ResultHandler<UserModel> resultHandler);

}
