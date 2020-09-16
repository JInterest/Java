package com.homework.Gather.three;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Student liusan=new Student("liusan",20,90.0F);
        Student lisi=new Student("lisi",22,90.0F);
        Student wangwu=new Student("wangwu",20,99.0F);
        Student sunliu=new Student("sunliu",22,100.0F);

        List<Student> l=new ArrayList();

        l.add(liusan);
        l.add(wangwu);
        l.add(lisi);
        l.add(sunliu);
        Collections.sort(l);
        //内部类创建一个比较器类，排序时new一个比较器对象
//        Collections.sort(l,new Student.StudentComparetor());
        for (Student s:l
             ) {
            System.out.println(s);
        }

    }

}
