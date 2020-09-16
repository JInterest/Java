package com.test.dao;

import com.test.domain.Student;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:23
 */
public interface StudentDao {
    public Student selectById(String id);
    public void addStu(Student s);

}
