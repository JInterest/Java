package com.homework.the4;

public class test {

    static void makeFly(CanFly a)
    {
        System.out.println("准备起飞！");
    }

    public static void main(String[] args) {
        Airplane airplane=new Airplane();
        airplane.fly();
        //多态
        CanFly a=airplane;
        test.makeFly(a);

        Bird bird=new Bird();
        bird.fly();
        CanFly b=bird;
        test.makeFly(b);
//        bird.makeFly("小鸟");
//        airplane.makeFly("波音747");
    }
}
