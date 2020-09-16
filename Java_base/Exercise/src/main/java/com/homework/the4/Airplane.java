package com.homework.the4;
/*1）定义一个接口CanFly，描述会飞的方法public void fly();
（2）分别定义类飞机和鸟，实现CanFly接口。
（3）定义一个测试类，测试飞机和鸟，在main方法中创建飞机对象和鸟对象，

再定义一个makeFly()方法，其中让会飞的事物飞。并在main方法中调用该方法，让飞机和鸟起飞。*/
public class Airplane implements CanFly {
    String AirplaneName;
    @Override
    public void fly() {
        System.out.println("飞机  化工能源飞行");
    }

    public void makeFly(String name){
        this.AirplaneName =name;
        System.out.println(name+":起飞");
    };
}
