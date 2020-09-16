package cn.JInterest.demo12306;

public class test {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        Thread t=new InitTicketThread(ticket,"初始化车票线程");

        // 等初始化线程初始化好车票之后,才能开始卖票
        try {
            t.join();//t线程合并到当前线程，当前线程受阻塞，t线程执行直到结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t1=new saleThread(ticket,"售票窗1");
        Thread t2=new saleThread(ticket,"售票窗2");
        Thread t3=new saleThread(ticket,"售票窗3");
        Thread t4=new saleThread(ticket,"售票窗4");


    }
}
