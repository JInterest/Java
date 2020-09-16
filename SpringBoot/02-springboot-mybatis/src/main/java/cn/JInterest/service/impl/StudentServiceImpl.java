package cn.JInterest.service.impl;

import cn.JInterest.mapper.StudentMapper;
import cn.JInterest.model.Student;
import cn.JInterest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/06/07  17:07
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int delStudent(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public Student queryStudent(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
