package cn.JInterest.createthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/04  19:43
 * @Description:  实现 Callable 接口，有返回值线程
 */
public class CallableTest implements Callable {

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i <=100 ; i++) {
            sum+=i;
        }
        // System.out.println(Thread.currentThread().getName());
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            Callable c=new CallableTest();
            // 执行任务并获取 Future 对象
            // 会创建一个新线程(执行任务的线程)去执行这个Callable的call方法
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println(Thread.currentThread().getName() +"--"+ f.get().toString());
        }
    }
}
