package com.laijinhan.dto;

import lombok.Data;

import java.util.ArrayList;

/**
 * @Author laijinhan
 * @date 2020/9/17 2:45 下午
 */

@Data
public class TeacherDTO {
    private int tid;
    private String name;

    private ArrayList<StudentDTO> students;
}
