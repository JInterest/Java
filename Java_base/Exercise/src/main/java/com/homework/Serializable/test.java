package com.homework.Serializable;

public class test {
    public static void main(String[] args) {
        Thread t=new Thread(new StudentSystem());
        t.start();
    }
}
