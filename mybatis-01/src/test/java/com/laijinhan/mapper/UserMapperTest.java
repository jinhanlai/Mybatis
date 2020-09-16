package com.laijinhan.mapper;

import com.laijinhan.dto.UserDTO;
import com.laijinhan.utils.MybatisUtils;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author laijinhan
 * @date 2020/9/15 6:06 下午
 */


public class UserMapperTest {
    @Test
    public void test() {
        //先获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 根据反射获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<UserDTO> userList = mapper.getUserList();
        for (UserDTO user : userList) {
            System.out.println(user);
        }
        //关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void addUserTest() {
        //先获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 根据反射获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new UserDTO(6,"王七","123456"));
        sqlSession.commit();
        //关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void addUser1Test() {
        //先获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 根据反射获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String,String> map =new HashMap<>();
        map.put("id","7");
        map.put("name","李六");
        map.put("pwd","123456");
        mapper.addUser1(map);
        sqlSession.commit();
        //关闭sqlsession
        sqlSession.close();
    }

}
