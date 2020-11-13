package com.zju.demo2_Anno.Model;

import lombok.*;

/**
 * @author 况祥彬
 * @date 2020/11/11 23:00
 **/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Integer id;
    private String name;
}
