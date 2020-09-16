package com.text.pack02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/22  21:54
 */
@Component
public class Student {
    //可以在属性上，也可以在set方法上
    @Value("李四")
    private String name;
    @Value("20")
    private int age;

    //@Resource来自jdk的注解 spring框架提供了对这个注解的功能支持，默认byName，设置byType @Resource（name=byType）

    //@Autowired 默认byType  用byName加@Qualifier注解
    //@Autowired(required=true) 默认true 注入失败报错，required=false 注入失败值为null。
    @Autowired
    @Qualifier("mySchool")
    private School school;

    public Student() {
    }

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
