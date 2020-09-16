package com.homework.the3;

public class test {
    public static void main(String[] args) {
        UseCompute a=new UseCompute();
        a.useCom(new Add(), 5, 6);
        a.useCom(new Subtract(), 5, 6);
        a.useCom(new Multiply(), 5, 6);
        a.useCom(new Divide(), 30, 6);
/*
* --------------------------
* 匿名内部类
* */
        a.useCom(new Compute() {
            @Override
            public int Computer(int n, int m) {
                return n+m;
            }
        },5,6);


    }
}
