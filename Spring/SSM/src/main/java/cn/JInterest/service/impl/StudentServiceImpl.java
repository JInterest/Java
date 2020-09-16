package cn.JInterest.service.impl;

import cn.JInterest.dao.StudentDao;
import cn.JInterest.domain.Student;
import cn.JInterest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/06/06  10:38
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier(value = "studentDao")
    private  StudentDao studentDao;


    public StudentServiceImpl(StudentDao dao) {
        this.studentDao = dao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.selectAllStudents();
    }
}
