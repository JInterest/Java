package cn.JInterest.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  10:22
 * @Description: i++不是原子操作 volatile非原子性不能保障线程安全，可以使用synchronized同步或原子类进行实现
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
        Thread.sleep(1000);
        System.out.println(MyThread.count.get());
    }

    static class MyThread extends Thread{
        private static AtomicInteger count = new AtomicInteger();

        public static void addCount(){

            for (int i = 0; i < 10000; i++) {
                count.getAndIncrement();//count++
            }
            System.out.println(Thread.currentThread().getName()+"count="+count.get());
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
