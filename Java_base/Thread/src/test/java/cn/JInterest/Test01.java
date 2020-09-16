package cn.JInterest;

import java.util.Random;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  9:44
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("sda"+new Random().nextInt(1000));
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }
            }
        };
        t.start();

    }
}
