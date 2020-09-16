package cn.JInterest.method;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/04  21:32
 * @Description:测试 yield()  线程让步, 放弃 CPU 执行权
 */
public class Yield extends Thread {
    public static void main(String[] args) {
        Thread thread = new Yield();
        thread.start();

        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 1; i <= 1000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"用时: " + (end - begin));

    }

    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 1; i <= 1000000; i++) {
            sum += i;
            Thread.yield(); //让步之后还可能再抢到

        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"用时: " + (end - begin));

    }
}