package com.test.test;

import com.test.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/16  18:41
 */
public class Test1 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sqlSessionFactory这个对象为我们创建SqlSession对象

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        //查找某个学生
        Student s = session.selectOne("test1.selectById", "A0002");
        System.out.println(s);
/*         //查找全部学生
        List<Student> students = session.selectList("test1.selectAll");
        System.out.println(students);
*/
        /*
         MyBatis默认情况下是手动提交事务
        */
        //``````````````````````````添加操作
/*      Student student=new Student();
        student.setId("a0006");
        student.setName("ll");
        student.setAge(22);
        session.insert("test1.addStu",student);
        session.commit();*/
        //``````````````````````````修改操作
/*      Student student=new Student();
        student.setId("a0006");
        student.setName("lq");
        student.setAge(23);
        session.update("test1.updateStu",student);
        session.commit();*/
        //``````````````````````````删除操作
/*        Student student=new Student();
        student.setId("a0006");
        session.delete("test1.deleteStu",student);
        session.commit();
*/

        session.close();
    }
}
