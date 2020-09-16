package com;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random r=new Random();

        int[] arr=new int[5];

        for (int i = 0; i <arr.length ; i++) {
            arr[i]=-1;
        }
        //循环生成随机数
        int index=0;
        int count = 0;
        while (index < arr.length){
            int num=r.nextInt(5);
            count++;
            if (!contains(arr,num)){
                arr[index++]=num;
                System.out.println("生成的随机数--->"+num);
            }
        }
        System.out.println("产生随机数次数："+count);

       /* for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }*/
    }


    public static boolean contains(int[] arr, int key) {
        //排序 在用二分法查找

/*      //出 bug（排序出问题） -1 -1 1 2 3
        Arrays.sort(arr);

        return Arrays.binarySearch(arr,key)>=0;
*/
        for (int i = 0; i <arr.length ; i++) {
            if (key == arr[i]){
                return true;
            }
        }return false;

    }
}

