package com.zju.demo2_Anno.Model;


import com.zju.demo1.model.OrderDetailModel;
import lombok.*;

import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/11 21:37
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderModel {
    private Integer id;
    private Integer userId;
    private Long createTime;
    private Long upTime;

    //一对一查询 查询order时查出user
    private UserModel userModel;

    //一对多 查询order查出订单详情列表
    private List<OrderDetailModel> orderDetailModelList;

}
