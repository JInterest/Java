package com.test.entity;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/14  19:44
 */
public class Student {
    int sid;
    String sName,sex,className;

    public Student(int sid, String sName, String sex, String className) {
        this.sid = sid;
        this.sName = sName;
        this.sex = sex;
        this.className = className;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
