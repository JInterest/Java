package com.homework.the2;

public class test {
    public static void main(String[] args) {
        Cylinder cl=new Cylinder(2,2,"blue");
       // String cl1=cl.toString();
        System.out.println(cl);
        cl.volume();
        cl.area();

        System.out.println("------------------");
        C c=new Cylinder(1,2,"while");
        //System.out.println(c.toString());
        System.out.println(c);
        c.volume();
        c.area();

        System.out.println("------------------");
        A a=new Cylinder(3,3,"black");
        System.out.println(a.toString());
        A a1=new Cylinder();
        ((C) a).volume();
        a.area();
    }
}
