package com.zju.demo1.dto;

import lombok.*;

/**
 * @author 况祥彬
 * @date 2020/11/10 23:08
 * 当参数比较多，但是具体有多少个参数我们是确定的时候，我们可以将这些参数放在一个javabean对象中。

如我们想通过userId和userName查询，可以定义一个dto对象，属性添加对应的get、set方法，如：
 **/
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFindDto {
    private Long userId;
    private String userName;
    private String name;
}