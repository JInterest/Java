package cn.jinterest.service.impl;

import cn.jinterest.dao.StudentDao;
import cn.jinterest.domain.Student;
import cn.jinterest.service.StudentService;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/28  13:18
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    //使用set投值注入
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);

    }

    @Override
    public List<Student> selectStudents() {
        return studentDao.selectStudents();

    }
}
