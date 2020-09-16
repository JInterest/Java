package cn.JInterest.method.wait_notify;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/04  20:41
 * @Description: 让两个线程使用 wait 和 notify 交互对一个数字+1
 */
public class Amount {
    private int number = 1;
    //boolean flag  = true ; 加给个标记奇数true 偶数false


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int sum() {
        return number++;
    }
}

/**
 * 线程一：如果amount得到数字是 偶数，执行wait方法
 */
class Thread01 extends Thread {

    private Amount amount;

    public Thread01(Amount amount) {
        this.amount = amount;
    }

    //run 里面的受检异常不能往上抛，父类没继承Exception
    public void run() {
        synchronized (amount) {
            try {
                while (true) {
                    if (amount.getNumber() % 2 == 0) {
                        amount.wait();
                    }
                    Thread.sleep(1000);//方便观察
                    System.out.println(Thread.currentThread().getName() + "--->" + amount.getNumber());
                    amount.sum();
                    amount.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 线程二：如果amount得到数字是 奇数，执行wait方法
 */
class Thread02 extends Thread {

    private Amount amount;

    public Thread02(Amount amount) {
        this.amount = amount;
    }

    public void run() {
        synchronized (amount) {
            try {
                while (true) {
                    if (amount.getNumber() % 2 != 0) {
                        amount.wait();
                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "--->" + amount.getNumber());
                    amount.sum();
                    amount.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}