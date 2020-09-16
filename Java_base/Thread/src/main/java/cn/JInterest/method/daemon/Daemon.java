package cn.JInterest.method.daemon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *  守护线程 ：定时任务、 垃圾回收器GC
 *  守护线程不能单独运行, 当 JVM 中没有其他用户线程,只有守护线 程时,守护线程会自动销毁, JVM 会退出
 */
public  class Daemon {
    public static void main(String[] args) throws ParseException {
        Thread t=new ThreadTest();
        t.start();


        Timer timer=new Timer(true);//定时任务

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime=sdf.parse("2020-09-04 21:26:00");
        timer.schedule(new logTask(),firstTime,1000*10);

        for (int i = 0; i <30 ; i+=2) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }

    }
}

class logTask extends TimerTask{

        @Override
        public void run() {

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date=new Date();
                String d=sdf.format(date);
                System.out.println("保存数据---"+d);

        }
    }

class ThreadTest extends Thread{
    public void run(){
        for (int i = 0; i <30 ; i+=2) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }
    }
}