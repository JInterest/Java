package com.homework.Serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class Initialized {
    public static List<Student> initialized(){
        ObjectInputStream ois = null;
        //逆序列化学生信息文件，若没有文件，则初始化一个空的学生信息文件。因为OCP原则读取文件的地址用到了
        // Thread.currentThread().getContextClassLoader().getResource("").getPath()方法

        //Thread.currentThread().getContextClassLoader().getResource("StudentInfo")
        // ---->file:/D:/IDEA/Projects/Exercise/target/classes/StudentInfo
        //上面得到的是ClassPath的绝对URI路径。通过.getPath()获取真实路径 类的根路径下（src是类的根路径）
        //Thread.currentThread().getContextClassLoader().getResource("StudentInfo").getPath()
        // ---->/D:/IDEA/Projects/Exercise/target/classes/StudentInfo
        try {
            ois = new ObjectInputStream(new FileInputStream("./src/main/java/com/homework/Serializable/StudentInfo"));
            List<Student> students =  (List<Student>) ois.readObject();
            return students;
        } catch (IOException | ClassNotFoundException|NullPointerException e) {
            return new ArrayList<Student>();
        }finally {
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}