package com;

import java.util.Scanner;

public class Order {

        static int x,xx,y,yy; static double sum=0;

        public static void main(String[] args)
        {


            String answer="y";double h=0;
            Scanner input=new Scanner(System.in);
            System.out.println("请输入客户数：");
            int m=input.nextInt();
            int n=m*3;//茶位费
            tostring();
            do
            {
//                点餐
                order();
                h+=(s(x,xx))+(d(y,yy));
                System.out.println("是否继续：");
                answer=input.next();
                if(answer.equals("n"))
                    break;

            }while(true);
            //结账
            System.out.println(h+n);
        }
        static void tostring()
        {
            System.out.println("菜单");
            System.out.println("食品：");
            System.out.println("1咖喱牛肉饭￥40.00");
            System.out.println("2寿司套餐￥65.00");
            System.out.println("3扬州市消防3米￥45.00");
            System.out.println("4沙朗牛排和意大利面￥72.00");
            System.out.println("5鸡肉蔬菜卷￥42.00");
            System.out.println("饮料：");
            System.out.println("21软饮料￥10.00");
            System.out.println("22红葡萄酒￥15.00");
            System.out.println("23啤酒￥15.00");
        }
        static double s(int f,int x)
        {
            double p=0;
            switch(f)
            {
                case 1:p=40.00;break;
                case 2:p=65.00;break;
                case 3:p=45.00;break;
                case 4:p=72.00;break;
                case 5:p=42.00;break;

            }
            sum=p*x;
            return sum;
        }
        static double d(int f,int x)
        {
            double p=0;
            switch(f)
            {
                case 21:p=10.00;break;
                case 22:p=15.00;break;
                case 23:p=15.00;break;
            }
            sum=p*x;
            return sum;
        }
        static void order()
        {
            Scanner input=new Scanner(System.in);
            System.out.println("请选择食品：");
            x=input.nextInt();
            System.out.println("请选择份数：");
            xx=input.nextInt();
            System.out.println("请选择饮料：");
            y=input.nextInt();
            System.out.println("请选择瓶数：");
            yy=input.nextInt();

        }
    }


