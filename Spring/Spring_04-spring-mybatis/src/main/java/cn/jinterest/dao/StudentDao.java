package cn.jinterest.dao;

import cn.jinterest.domain.Student;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/27  23:44
 */
public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
