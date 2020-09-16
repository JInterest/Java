package com.homework.Gather.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList {
/*1.
 *   产生10个1-100的随机数，并放到一个数组中，
 *   把数组中大于等于10的数字放到一个list集合中，
 *   并打印到控制台
 * */
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            arr[i] = r.nextInt(100) + 1;
            if (arr[i] >= 10) {
                l.add(arr[i]);
            }
        }

        //遍历 集合 查看随机数大于等于10的个数有几个
        for (Integer list:l
             ) {
            System.out.println(list);
        }
        System.out.println("放入集合中的元素有："+l.size()+"个。");
    }

}
