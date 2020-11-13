package com.zju.demo1.model;

import lombok.*;

/**
 * @author 况祥彬
 * @date 2020/11/11 19:43
 **/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private Integer num;
    private Double totalPrice;
}
