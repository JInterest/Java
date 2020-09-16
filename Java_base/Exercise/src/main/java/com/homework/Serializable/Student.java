package com.homework.Serializable;

import java.io.Serializable;
/*1、请使用序列化和反序列化机制，完成学生信息管理系统。

系统打开时显示以下信息：
欢迎使用学生信息管理系统，请认真阅读以下使用说明：
请输入不同的功能编号来选择不同的功能：
[1]查看学生列表
[2]保存学生
[3]删除学生
[4]查看某个学生详细信息

--------------------------------------------------------------------
学生信息列表展示
学号			姓名			性别
------------------------------------
1				zhangsan		男
2				lisi			女
.....

--------------------------------------------------------------------
查看某个学生详细信息
学号：1
姓名：张三
生日：1990-10-10
性别：男
邮箱：zhangsan@123.com

---------------------------------------------------------------------
删除学生时，需要让用户继续输入删除的学生编号，根据编号删除学生。


注意：请使用序列化和反序列化，以保证关闭之后，学生数据不丢失。
学生数据要存储到文件中。*/
/*
* 版本1  基本功能已实现  细节有空再来改  ~_~
* */
public class Student implements Serializable {
    private static final long serialVersionUID = 6430320869554241675L;//有序列化版本号 修改类之后还可以反序列化。
    private int no;
    private String name;
    private String birthday;
    private String sex;
    private String email;

    public Student() {
    }

    public Student(int no, String name, String birthday, String sex, String email) {
        this.no = no;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.email = email;
    }


    public String toString() {
        return "学号："+no+"\n"+
                "姓名："+name+"\n"+
                "生日："+birthday+"\n"+
                "性别："+sex+"\n"+
                "邮箱："+email+"\n";
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return no == student.no;
    }



    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
