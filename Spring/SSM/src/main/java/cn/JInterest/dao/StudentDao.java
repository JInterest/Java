package cn.JInterest.dao;

import cn.JInterest.domain.Student;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/06/06  10:28
 */
public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectAllStudents();
}
