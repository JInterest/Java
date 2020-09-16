package com.test.domain;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/16  18:12
 */
public class Student {
    String name;
    String id;
    Integer age;

    public Student() {
    }
    
    public Student(String name, String id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
