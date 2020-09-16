package cn.jinterest.service;

import cn.jinterest.domain.Student;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/28  13:17
 */
public interface StudentService {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
