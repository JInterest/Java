package com.test.dao;


import com.test.domain.Student;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:23
 */
public interface StudentDao {

    Student selectById(String id);
    void addStu(Student s);
    List<Student> selectAll();
    void dleById(String id);
    void updateStu(Student student);
    List<Student> selectAll2();
    List<Student> find(Student s);
    List<Student> selectById2(String[] stuArr);

}
