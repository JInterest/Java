package com.homework.HotelSystem;

import java.util.Scanner;

/*java软件工程师人生路上第一个小型项目。锻炼一下面向对象。）
	为某个酒店编写程序：酒店管理系统，模拟订房、退房、打印所有房间状态等功能。
	1、该系统的用户是：酒店前台。
	2、酒店使用一个二维数组来模拟。“Room[][] rooms;”
	3、酒店中的每一个房间应该是一个java对象：Room
	4、每一个房间Room应该有：房间编号、房间类型、房间是否空闲.
	5、系统应该对外提供的功能：
		可以预定房间：用户输入房间编号，订房。
		可以退房：用户输入房间编号，退房。
		可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态。*/
public class HotelMgetSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        /*进入系统*/
        System.out.println("欢迎使用酒店管理系统，请认真阅读以下使用说明`");
        System.out.println("功能编号对应功能：【1】表示查看房间列表，【2】表示订房，【3】表示退房" +
                "，【0表示推出系统】");
        Scanner s = new Scanner(System.in);
        System.out.print("请输入功能编号：");

        while (true) {
            int i = s.nextInt();
            if (i == 1) {
                hotel.look();
            } else if (i == 2) {
                System.out.println("请输入房间号:");
                hotel.Reservation(s.nextInt());

            } else if (i == 3) {
                System.out.println("请输入房间号:");
                hotel.Refund(s.nextInt());
            } else if(i==0) {
                System.out.println("即将关闭系统...");
                return;
            }else{
                System.out.println("输入有误，请重新输入:");
            }

        }
    }
}
