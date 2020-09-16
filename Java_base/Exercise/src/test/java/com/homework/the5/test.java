package com.homework.the5;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请设置您的武器容量：");
        int n=s.nextInt();
        Army a=new Army(n);

        System.out.println("输入yes添加武器,输入其他则不录入");
        String m = s.next();//添加武器
        while(m.equals("yes")) {
            System.out.println("1.Tank  2.Fighter  3.Warship  4.高射炮");
            System.out.println("请选择：");
            int l = s.nextInt();//请选择武器种类

         if(l==1){
             a.addWeapon(new Tank());
         }else if(l==2){
             a.addWeapon(new Fighter());
         }else if(l==3) {
             a.addWeapon(new Warship());
         }else if(l==4){
                 a.addWeapon(new GaoShePao());
         }else{
             System.out.println("输入错误");
         }

         System.out.println("输入yes添加武器,输入其他则退出");
         m = s.next();
        }
        a.moveAll();
        a.attackAll();

}

}

