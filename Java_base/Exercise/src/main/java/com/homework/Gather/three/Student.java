package com.homework.Gather.three;

import java.util.Comparator;

/*
3.编写一个Student类用来实现Comparable<Student>接口,并在其中重写CompareTo(Student o)方法　
在主函数中使用Comparable 与 Comparetor分别对ArrayList进行排序.
分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，如果成绩一样，
那在成绩排序的基础上按照年龄由小到大排序。

姓名（String）年龄（int）分数（float）
liusan			20				90.0F
lisi			22			    90.0F
wangwu			20				99.0F
sunliu			22				100.0F
* */
public class Student implements Comparable<Student>{
    String name;
    int age;
    float score;

    public Student() {
    }

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    //k.compareTo(t.key)
    //参数k是拿来与集合中每一个t.key来比较的
    //如果升序 k（this）-t.key,反之。

    @Override
    public int compareTo(Student o) {//s1.compareTo(s2);
        if (this.score == o.score){
            return this.age-o.age;
        }else return (int) (o.score-this.score);
    }

    //使用内部类创建比较器
    static class StudentComparetor implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o2.score == o1.score){
            return o1.age-o2.age;
        }return (int) (o2.score-o1.score);
    }
   }
}

