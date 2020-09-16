package cn.JInterest.service;

import cn.JInterest.domain.Student;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/06/06  10:36
 */
public interface StudentService {
    int addStudent(Student student);
    List<Student> findAllStudents();

}
