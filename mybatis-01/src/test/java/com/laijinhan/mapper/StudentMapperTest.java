package com.laijinhan.mapper;

import com.laijinhan.dto.StudentDTO;
import com.laijinhan.dto.TeacherDTO;
import com.laijinhan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author laijinhan
 * @date 2020/9/17 2:55 下午
 */


public class StudentMapperTest {

    @Test
    public  void getStudentTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentDTO> studentList = mapper.getStudent();
        for(StudentDTO student:studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public  void getStudentTest1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentDTO> studentList = mapper.getStudent1();
        for(StudentDTO student:studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }


}
