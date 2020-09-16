package cn.JInterest.reentrantLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static cn.JInterest.reentrantLock.ReentrantLockDemo.lock;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  16:08
 * @Description: 方法的作用:如果当前线程未被中断则获得锁, 如果当前线程被中断则出现异常.可以使用此方法解决死锁问题
 */
public class LockInterruptiblyDemo implements Runnable {
    //定义显示锁
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();
    int lockNum; //定义整数变量,决定使用哪个锁

    public LockInterruptiblyDemo(int lockNum) {
        this.lockNum = lockNum;
    }

    @Override
    public void run() {
        try {
            if (lockNum % 2 == 1) {//奇数,先锁 1,再锁 2
                //if(lock1.tryLock())  也可以使用tryLock() tryLock(long time, TimeUnit unit) 解除死锁
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "获得锁 1,还需 要获得锁 2");
                Thread.sleep(new Random().nextInt(500));
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "同时获得了锁1 与锁 2....");

            } else if (lockNum % 2 == 0) {//偶数,先锁 2,再锁 1
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "获得锁 2,还需 要获得锁 1");
                Thread.sleep(new Random().nextInt(500));
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "同时获得了锁 1 与锁 2....");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) //判断当前线程是否持有该锁
                lock1.unlock();
            if (lock2.isHeldByCurrentThread())
                lock2.unlock();
            System.out.println(Thread.currentThread().getName() + "线程退出");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LockInterruptiblyDemo demo1 = new LockInterruptiblyDemo(11);
        LockInterruptiblyDemo demo2 = new LockInterruptiblyDemo(22);

        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);
        t1.start();
        t2.start();

        //在 main 线程,等待 3000 秒,如果还有线程没有结束就中断该线程
        Thread.sleep(3000);
        //可以中断任何一个线程来解决死锁, t2 线程会放弃对锁 1 的申请,同时释放锁 2, t1 线程会完成它的任务
        if (t2.isAlive()) {
            t2.interrupt();
        }

    }


}
