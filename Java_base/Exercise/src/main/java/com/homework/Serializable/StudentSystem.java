package com.homework.Serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSystem implements Runnable{
    List<Student> students=new ArrayList<>();

    @Override
    public void run() {
        //调用初始化方法读取学生信息。（之前通过序列化保存的对象）
        students= Initialized.initialized();
        /*for (Student s:students
             ) {
            System.out.println(s);
        }*/
        System.out.println("欢迎使用学生信息管理系统，请认真阅读以下使用说明：");
        System.out.println("请输入不同的功能编号来选择不同的功能：");
        System.out.println("[1]查看学生列表"+ "\n"+"[2]保存学生"+"\n"+"[3]删除学生"+"\n"+
                            "[4]查看某个学生详细信息"+"\n"+"[5]添加学生"+"\n"+"[0]退出系统");

        Scanner sc=new Scanner(System.in);
        while(true) {
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("学生信息列表展示");
                    System.out.println("学号\t\t\t姓名\t\t\t性别");
                    System.out.println("--------------------------------------------------------------------");
                    for (Student s:students
                         ) {
                        System.out.println(s.getNo()+"\t\t\t"+s.getName()+"\t\t\t"+s.getSex());
                    }
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case 2:save(); break;
                case 3:
                    System.out.print("请输入要删除的学生的学号：");
                    delete(new Scanner(System.in).nextInt()); break;
                case 4:
                    System.out.print("请输入查看学生的学号：");
                    check(new Scanner(System.in).nextInt()); break;
                case 5:
                    System.out.print("请输入学生的下列信息:\n姓名:");
                    String name = new Scanner(System.in).next();
                    System.out.print("学号:");
                    int no = new Scanner(System.in).nextInt();
                    System.out.print("性别:");
                    String sex= new Scanner(System.in).next();
                    System.out.print("生日(yyyy-MM-dd):");
                    String birth = new Scanner(System.in).next();
                    System.out.print("邮箱:");
                    String email = new Scanner(System.in).next();
                    addStudent(no,name,birth,sex,email);
                    break;
                case 0:return;
                default:
                    System.out.println("请输入对应功能编号！！！");
            }
        }
    }
// 查看学生列表方法

    private void save() {
        ObjectOutputStream oos=null;
        try {
            //从idea默认当前路径下的相对路径
            oos=new ObjectOutputStream(new FileOutputStream("./src/main/java/com/homework/Serializable/StudentInfo"));
            oos.writeObject(students);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//删除学生
    private void delete(int no) {
        for (Student s:students
             ) {
            if (s.getNo()==no){
                students.remove(s);
                System.out.println("学号为"+no+"的学生，删除成功");
                return;
            }
        }
        System.out.println("学生不存在！！！请重新输入：");
        delete(new Scanner(System.in).nextInt());
    }
//查看某个学生
    private void check(int no) {
        for (Student s:students
             ) {
            if (s.getNo()==no){
                System.out.println("学号："+s.getNo()+"\n"+
                        "姓名："+s.getName()+"\n"+
                        "生日："+s.getBirthday()+"\n"+
                        "性别："+s.getSex()+"\n"+
                        "邮箱："+s.getEmail()+"\n");
                return;
            }
        }
        System.out.println("学生不存在！！！请重新输入：");
        check(new Scanner(System.in).nextInt());
    }
//添加学生 并按学号以升序排序
    private void addStudent(int no,String name,String birthday,String sex,String email) {
        Student stu=new Student(no,name,birthday,sex,email);
        if (students.size()==0){
            students.add(stu);
        }else {
            for (Student s:students) {
                if (s.getNo()>stu.getNo()){
                    students.add(students.indexOf(s),stu);
                    System.out.println("添加成功");
                    return;
                }
            }
            students.add(stu);
        }
    }
}
