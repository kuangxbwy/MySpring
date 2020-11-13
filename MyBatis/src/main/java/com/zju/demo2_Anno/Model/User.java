package com.zju.demo2_Anno.Model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 况祥彬
 * @date 2020/11/11 21:48
 **/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;
}
