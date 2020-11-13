package com.zju.demo1.mapper;

import com.zju.demo1.model.OrderModel;

/**
 * @author 况祥彬
 * @date 2020/11/11 18:19
 **/
public interface OrderMapper {

    OrderModel getById(int id);
    OrderModel getById1(int id);
    OrderModel getById2(Integer id);


}
