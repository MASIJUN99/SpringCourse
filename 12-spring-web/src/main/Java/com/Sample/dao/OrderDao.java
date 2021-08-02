package com.Sample.dao;

import com.Sample.domain.Student;

import java.util.List;

public interface OrderDao {

    int insertStudent(Student student);
    List<Student> selectStudents();

}
