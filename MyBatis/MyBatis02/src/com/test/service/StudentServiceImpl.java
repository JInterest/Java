package com.test.service;

import com.test.dao.StudentDao;
import com.test.dao.StudentDaoImpl;
import com.test.domain.Student;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:44
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao=new StudentDaoImpl();
    @Override
    public Student selectById(String id) {
        Student s = studentDao.selectById(id);
        return s;
    }

    @Override
    public void addStu(Student s) {
        studentDao.addStu(s);
    }
}
