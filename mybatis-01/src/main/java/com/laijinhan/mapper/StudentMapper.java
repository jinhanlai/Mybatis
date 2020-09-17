package com.laijinhan.mapper;

import com.laijinhan.dto.StudentDTO;

import java.util.List;

/**
 * @Author laijinhan
 * @date 2020/9/17 2:47 下午
 */


public interface StudentMapper {
    public List<StudentDTO> getStudent();
    public List<StudentDTO> getStudent1();
}
