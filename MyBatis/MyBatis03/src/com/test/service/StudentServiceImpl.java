package com.test.service;

import com.test.dao.StudentDao;
import com.test.domain.Student;
import com.test.util.SqlSessionUtil;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:44
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao= SqlSessionUtil.getSession().getMapper(StudentDao.class);
    @Override
    public Student selectById(String id) {
        Student s = studentDao.selectById(id);
        return s;
    }

    @Override
    public void addStu(Student s) {
        studentDao.addStu(s);
    }
    public List selectAll(){
        return studentDao.selectAll();
    }

    @Override
    public void delById(String id) {
        studentDao.dleById(id);
    }

    @Override
    public void updateStu(Student student) {
        studentDao.updateStu(student);
    }

    @Override
    public List<Student> selectAll2() {
        return studentDao.selectAll();
    }
    public List<Student> find(Student s){
        return studentDao.find(s);
    }
    public List<Student> selectById2(String[] stuArr){
        return studentDao.selectById2(stuArr);
    }
}
