package com.laijinhan.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author laijinhan
 * @date 2020/9/15 5:53 下午
 */

@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String name;
    private String pwd;
}
