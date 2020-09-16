package com.homework.Gather.two;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
* 2.已知数组存放一批QQ号码，QQ号码最长为11位，
* 最短为5位String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}。
* 将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，
* 将list中所有元素分别用迭代器和增强for循环打印出来。*/
public class ListTest01 {
    public static void main(String[] args) {
        String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
        List<String> l=new LinkedList();
        for (int i = 0; i <strs.length ; i++) {
            l.add(strs[i]);
        }
        //删除集合中重复元素
        ListTest01.removeDuplicate(l);
    //迭代器遍历Linked
        /*Iterator<String> it=l.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/
    //foreach遍历Linked
        for (String s:l
             ) {
            System.out.println(s);
        }
    }
    //删除list集合重复元素方法
    public   static   void  removeDuplicate(List list)   {
        HashSet h  =  new  HashSet(list);
        list.clear();
        list.addAll(h);
        //System.out.println(list);
    }
}
