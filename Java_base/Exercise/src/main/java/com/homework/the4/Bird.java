package com.homework.the4;

public class Bird implements CanFly {
    String BirdName;
    @Override
    public void fly() {
        System.out.println("鸟  生物能源飞行");
    }

    public void makeFly(String name){
        this.BirdName =name;
        System.out.println(name+":起飞");
    };
}
