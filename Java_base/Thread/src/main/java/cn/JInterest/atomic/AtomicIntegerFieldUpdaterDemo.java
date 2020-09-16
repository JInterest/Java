package cn.JInterest.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  13:26
 * @Description:
 *      AtomicIntegerFieldUpdater 可以对原子整数字段进行更新
 *      要求:
 *          1) 字符必须使用 volatile 修饰,使线程之间可见
 *          2) 只能是实例变量,不能是静态变量,也不能使用 final 修饰
 */
public class AtomicIntegerFieldUpdaterDemo {

    public static void main(String[] args) {
        User  user = new User(1001,10);

        for (int i = 0; i < 10; i++) {
            new SubThread(user).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

}

class SubThread extends Thread{

    private User user;
    private AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");//更新的类和字段

    public SubThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"="+ updater.getAndIncrement(user));

        }
    }
}

class User{
    private int id;
    private volatile int age;

    public User(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}