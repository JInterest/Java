package cn.JInterest.demo12306;

public class InitTicketThread extends Thread{
    private Ticket ticket;

//创建初始化线程对象时 就启动线程
    public InitTicketThread(Ticket ticket,String name) {
        super(name);//线程名字
        this.ticket=ticket;
        this.start();
    }

    public void run(){
        ticket.initTicket();
    }
}
