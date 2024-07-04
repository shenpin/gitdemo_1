package com.tzy.service.impl;
import com.tzy.mapper.StudentMapper;
import com.tzy.pojo.Student;
import com.tzy.service.StudentService;
import com.tzy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> getStudentList() {
        try {
            SqlSession sqlSession= MybatisUtil.getSqlSession();
            StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudentList();
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
return  null;
    }
}
