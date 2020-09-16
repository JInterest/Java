package cn.JInterest.method;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/04  21:38
 * @Description:测试 Interrupt() ,中断线程.
 * 注意调用 interrupt()方法仅仅是在当前线程打一个停止标志,并不 是真正的停止线程
 */
public class Interrupt extends Thread {
    public static void main(String[] args) {
        Interrupt thread = new Interrupt();
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main===>"+i);
        }
        //中断子线程，仅仅是标记中断
        thread.interrupt();
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            //判断线程的中断标志,线程有 isInterrupted()方法,该 方法返回线程的中断标志
            if (this.isInterrupted()) {
                System.out.println("当前线程的中断标志为 true, 我要退出了");
                //中断循环, run()方法体执行完毕, 子线程运行完毕
                //break;

                return; //直接结束当前 run()方法的执行
            }
            System.out.println("sub thread --> " + i);
        }
    }
}
