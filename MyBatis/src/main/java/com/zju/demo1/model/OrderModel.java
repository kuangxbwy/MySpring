package com.zju.demo1.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/11 18:19
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderModel implements Serializable {
    private Integer id;
    private Integer userId;
    private Long createTime;
    private Long upTime;
    //一对一查询 查询order是查出user
    private UserModel1 userModel;

    //一对多 查询order查出订单详情列表
    private List<OrderDetailModel> orderDetailModelList;
}
