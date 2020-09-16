package com.test.service;

import com.test.domain.Student;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:42
 */
public interface StudentService {
    Student selectById(String id);
    void addStu(Student s);
    List<Student> selectAll();
    void delById(String id);
    void updateStu(Student student);
    List<Student> selectAll2();
    List<Student> find(Student s);
    List<Student> selectById2(String[] stuArr);
}
