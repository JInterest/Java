package com.chapter.reflect;
//利用反射机制反编译class（了解）

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest01 {
    public static void main(String[] args) {
        //使用追加 "append()" 效率比 "+" 高
        //StringBuffer sb=new StringBuffer();
        StringBuilder sb=new StringBuilder();
        //获取Class 的三种方法
//        Class StringName=Class.forName("java.lang.String");
//        String s="s";
//        Class StringName=s.getClass();
        /**/
        Class SName=String.class;
        sb.append(Modifier.toString(SName.getModifiers())+" class "+SName.getSimpleName()+" {\n");
        Field[] fields=SName.getDeclaredFields();
        for (Field field:fields
             ) {
            sb.append("\t");
            sb.append(Modifier.toString(field.getModifiers()));
            sb.append(" ");
            sb.append(field.getType().getSimpleName());
            sb.append("\n");
        }
        sb.append("}");
        System.out.println(sb);

    }
}
