package com.laijinhan.mapper;

import com.laijinhan.dto.UserDTO;
import com.laijinhan.enums.Enabled;
import com.laijinhan.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author laijinhan
 * @date 2020/9/15 6:06 下午
 */


public class UserMapperTest {
    static Logger logger=Logger.getLogger(UserMapperTest.class);
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
        mapper.addUser(new UserDTO(11,"王十一","123456", Enabled.disabled));
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
    @Test
    public  void  testLog4j(){
        logger.info("进入log4j info信息");
        logger.debug("进入log4j debug信息");
    }

    @Test
    public void  getUserByRouwBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        /**
         * 从sql层面实现分页
         */
        List<UserDTO> userDTOList = sqlSession.selectList("com.laijinhan.mapper.UserMapper.getUserList", null, rowBounds);
        for(UserDTO user:userDTOList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void  getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /**
         * 从limit层面实现
         */
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Integer> map=new HashMap<>();
        map.put("offsetindex",1);
        map.put("pageindex",2);
        ArrayList<UserDTO> userDTOList = mapper.getUserLimit(map);
        for(UserDTO user:userDTOList){
            System.out.println(user);
        }

        sqlSession.close();
    }


}
