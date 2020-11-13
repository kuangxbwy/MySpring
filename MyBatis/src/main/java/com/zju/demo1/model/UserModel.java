package com.zju.demo1.model;

import lombok.*;

/**
 * @author 况祥彬
 * @date 2020/11/10 23:09
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private Integer sex;
}
