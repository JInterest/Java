package cn.JInterest.createthread;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/04  15:38
 * @Description: 1. 实现Runnable接口创建线程
 *               2. 继承Thread类创建线程
 */
public class MyThread01 implements Runnable {

    public static void main(String[] args) {
        /*MyThread mt=new MyThread();
        Thread t=new Thread(mt);*/
        Thread t = new Thread(new MyThread01());
        t.start();
        t.setName("分支线程");

        //获取当前线程
        Thread currentThread = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println(currentThread.getName() + "-->" + i);
        }
        //使当前线睡眠
        try {
            //t.sleep(2000); == Thread.sleep(2000);都是作用于当前线程
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello world!");
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread currentThread = Thread.currentThread();
            //Thread[Thread-0,5,main]   5是线程优先级别，抢到的cpu时间片可能比较多
            System.out.println(currentThread.getName() + "--->" + i);
        }
    }
}
/*//第一种方法（不建议）占用继承的位置
public class MyThread extends Thread{
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        //mt.run();
        mt.start();
        for (int i = 0; i <100 ; i++) {
            System.out.println("main线程-->"+i);
        }
    }
  public void  run(){
      for (int i = 0; i <100 ; i++) {
          System.out.println("分线程-->"+i);
      }
  }
}
*/

