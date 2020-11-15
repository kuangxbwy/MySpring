package com.zju.springboot.db.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author 况祥彬
 * @date 2020/11/15 20:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Component
public class Role {
    private int id;
    private String role_name;
    private String role_desc;
}
