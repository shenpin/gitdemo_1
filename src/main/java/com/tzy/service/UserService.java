package com.tzy.service;

import com.tzy.pojo.User;

public interface UserService {
    boolean validateUser(String username, String password);
    void register(User user) throws Exception;
    void deleteUser(User user) throws Exception;
}
