package cn.JInterest.createthread;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/04  15:47
 * @Description:  匿名内部类方式实现线程
 */
public class MyThread02  {
    public static void main(String[] args) {
        //匿名内部类  相当于new 匿名 implements Runnable(){}
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    System.out.println("分支线程-->"+i);
                }
            }
        });

        t.start();
        for (int i = 0; i <100 ; i++) {
            System.out.println("主线程-->"+i);
        }
    }
}
