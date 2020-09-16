package com.homework.Gather.five;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 6.定义一个泛型为String类型的List集合，统计该集合中每个字符
（注意，不是字符串）出现的次数。例如：集合中有”abc”、”bcd”两个元素，
程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
* */
public class ListTest02 {
    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        l.add("a");
        l.add("ab");
        l.add("abc");
       // System.out.println(ListTest02.frequencyOfListElements(l));
        ListTest02.frequencyOfListChars(l);

    }
    //求字符串出现的次数方法
  /* private static Map<String,Integer> frequencyOfListElements(List<String> list){
       if (list == null || list.size() == 0) return null;
       Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s:list
             ) {
            Integer count=map.get(s);
            map.put(s, (count == null) ? 1 : count + 1);
        }return map;
    }*/
    private static void frequencyOfListChars(List<String> list){
        //先把字符串拆开,放入ArrayList中
        //然后ArrayList转变成set集合，把重复字符去掉
        //再用set集合字符为代表，遍历ArrayList统计重复字符个数
        if (list == null || list.size() == 0) System.out.println("该集合为空");
        //高级写法 抛出异常 new 自定义的异常类("该集合为空")；
        List<Character> l=new ArrayList<>();
        for (String s:list
             ) {
            char[] c=s.toCharArray();
            for (int i = 0; i <c.length ; i++) {
               l.add(c[i]);
            }
        }
        Set<Character> set=new HashSet(l);
        for (Character chars:set
             ) {
            int sum=0;
            for (int i = 0; i <l.size() ; i++) {
                if (chars==l.get(i)) sum++;
            }
            System.out.println("字符["+chars+"]出现的次数="+sum);
        }
    }
}
