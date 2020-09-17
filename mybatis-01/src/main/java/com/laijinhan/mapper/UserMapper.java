package com.laijinhan.mapper;

import com.laijinhan.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author laijinhan
 * @date 2020/9/15 5:56 下午
 */


public interface UserMapper {
    //@Select("SELECT * FROM mybatis.user")
    ArrayList<UserDTO> getUserList();

    UserDTO queryUserById(@Param("id") int id);

    int addUser(UserDTO user);

    // 使用map进行查询扩展
    int addUser1(Map user);

    ArrayList<UserDTO> getUserLimit(HashMap<String, Integer> map);


}
