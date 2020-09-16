package cn.JInterest.threadLocal;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  15:40
 * @Description: ThreadLocal的set()，get() 底层是ThreadLocalMap 以当前线程为key 存取数据
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);
        threadLocal.set(2);
        threadLocal.set(3);
        System.out.println(threadLocal.get());

        Thread t = new Thread(){
            @Override
            public void run() {
                threadLocal.set(6);
                System.out.println(threadLocal.get());
            }
        };
        t.start();
    }
}
