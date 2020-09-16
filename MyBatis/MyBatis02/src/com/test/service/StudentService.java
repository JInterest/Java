package com.test.service;

import com.test.domain.Student;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:42
 */
public interface StudentService {
    public Student selectById(String id);
    public void addStu(Student s);
}
