package com.laijinhan.mapper;

import com.laijinhan.dto.TeacherDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @Author laijinhan
 * @date 2020/9/17 2:47 下午
 */


public interface TeacherMapper {

    TeacherDTO getTeacher(int id);

    // 获取一个teacher id 下所有的student
    TeacherDTO getTeacherAllStudents(@Param("id") int id);
}
