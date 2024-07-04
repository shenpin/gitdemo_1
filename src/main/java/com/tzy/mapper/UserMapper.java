package com.tzy.mapper;

import com.tzy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    void insertUser(User user);


    String validateUser(String username, String password);


    User getUserByUsername(String username);

    void deleteUser(User user);
}
