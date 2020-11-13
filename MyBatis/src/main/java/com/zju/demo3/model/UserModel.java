package com.zju.demo3.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author 况祥彬
 * @date 2020/11/12 11:45
 **/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
}
