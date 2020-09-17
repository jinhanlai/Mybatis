package com.laijinhan.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Author laijinhan
 * @date 2020/9/17 2:44 下午
 */


@Data
public class StudentDTO {
    private  int id;
    private String name;
    private TeacherDTO teacher;
}
