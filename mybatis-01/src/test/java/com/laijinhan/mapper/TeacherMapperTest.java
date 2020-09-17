package com.laijinhan.mapper;

import com.laijinhan.dto.StudentDTO;
import com.laijinhan.dto.TeacherDTO;
import com.laijinhan.utils.MybatisUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author laijinhan
 * @date 2020/9/17 4:25 下午
 */


public class TeacherMapperTest {
    @Test
    public  void  getTeacherTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        TeacherDTO teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public  void  getTeacherAllStudentsTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherDTO teacherAllStudents = sqlSession.getMapper(TeacherMapper.class).getTeacherAllStudents(1);
        System.out.println(teacherAllStudents);
        sqlSession.close();
    }

}
