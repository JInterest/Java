package com.homework.the6_Exception;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请设置用户名：");
        String username=s.next();
        System.out.println("请设置密码：");
        String psw=s.next();
        UserService us=new UserService();
        try {
            us.register(username,psw);
        } catch (IllegalNameException l) {
            System.out.println(l.getMessage());
        }
    }
}
