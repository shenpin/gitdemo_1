package com.tzy.mapper;

import com.tzy.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentMapper {
List<Student> getStudentList() throws SQLException;
}
