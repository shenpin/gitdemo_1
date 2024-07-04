package com.tzy.service.impl;

import com.tzy.mapper.UserMapper;
import com.tzy.pojo.User;
import com.tzy.service.UserService;
import com.tzy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public boolean validateUser(String username, String password) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            String result = userMapper.validateUser(username, password);
            return result != null;
        } finally {
            MybatisUtil.closeSqlSession();  // 确保Session在操作完成后关闭
        }
    }

    @Override
    public void register(User user) throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User existingUser = userMapper.getUserByUsername(user.getUsername());
            if (existingUser != null) {
                throw new Exception("用户名已存在");
            }
            userMapper.insertUser(user);
            sqlSession.commit();  // 提交事务
        } catch (Exception e) {
            sqlSession.rollback();  // 回滚事务
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();  // 确保Session在操作完成后关闭
        }
    }

    @Override
    public void deleteUser(User user) throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(user);
            sqlSession.commit();  // 提交事务
        } catch (Exception e) {
            sqlSession.rollback();  // 回滚事务
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();  // 确保Session在操作完成后关闭
        }
    }


}
