package cn.JInterest.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  16:08
 * @Description: ReentrantLock 的基本使用
 */
public class ReentrantLockDemo {
    //定义显示锁
    static Lock lock = new ReentrantLock();
    //定义方法
    public static void sm(){

        try {
            //先获得锁
            lock.lock();
            //可重入锁指可以反复获得该锁
            lock.lock();
            //for 循环就是同步代码块
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //Lock遇到异常不会自动释放锁 ，所以需要在finally中unlock()
            lock.unlock();
            lock.unlock();
        }
    }
}
