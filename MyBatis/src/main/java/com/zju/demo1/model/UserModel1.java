package com.zju.demo1.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author 况祥彬
 * @date 2020/11/11 19:17
 **/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("userModel1")
public class UserModel1 implements Serializable {
    private Integer id;
    private String name;
}
