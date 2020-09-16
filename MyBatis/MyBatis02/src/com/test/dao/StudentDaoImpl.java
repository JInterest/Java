package com.test.dao;

import com.test.domain.Student;
import com.test.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:26
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public Student selectById(String id) {
        SqlSession session = SqlSessionUtil.getSession();
        Student s = session.selectOne("test1.selectById", id);
        return s;
    }

    @Override
    public void addStu(Student s) {
        SqlSession session = SqlSessionUtil.getSession();
        session.insert("test1.addStu", s);
    }
}
