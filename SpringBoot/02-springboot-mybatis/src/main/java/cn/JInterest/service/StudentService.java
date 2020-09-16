package cn.JInterest.service;

import cn.JInterest.model.Student;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/06/07  17:02
 */
public interface StudentService {
    int addStudent(Student student);
    int delStudent(Integer id);
    int updateStudent(Student student);
    Student queryStudent(Integer id);
}
