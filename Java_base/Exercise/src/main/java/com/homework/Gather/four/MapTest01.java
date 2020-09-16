package com.homework.Gather.four;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
*   1.遍历集合，并将序号与对应人名打印。
	2.向该map集合中插入一个编码为5姓名为郭靖的信息
	3.移除该map中的编号为1的信息
	4.将map集合中编号为2的姓名信息修改为"周林"*/
public class MapTest01 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");

        Set<Map.Entry<Integer,String>> node=map.entrySet();
        for (Map.Entry<Integer,String> data:node
             ) {
            //System.out.println(data);
            System.out.println(data.getKey()+"---->"+data.getValue());
        }
        map.put(5,"郭靖");
        map.remove(1);
        map.put(2,"周林");
        System.out.println("-------------------------------");

        Set<Integer> s=map.keySet();
        for (Integer i:s
             ) {
            System.out.println(map.get(i));
        }

        System.out.println("-------------------------------");

    }
}
