package cn.JInterest.demo12306;

public class saleThread extends Thread implements saleTicket{
    private Ticket ticket;
    //int index=0; 一直从0 开始，导致 售票窗--->卖出null
    static int index = 0;

    //创建线程对象时 就启动线程
    public saleThread(Ticket ticket, String name) {
        super(name);//线程名字
        this.ticket = ticket;
        this.start();
    }

    public void run() {
        for (int i = 0; i < 60; i++) {
            try {
                saleTicket(ticket);
                //ticket.saleTicket();
            } catch (TicketNullException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

    }

    public void saleTicket(Ticket t)  throws TicketNullException {
        synchronized (ticket) {
            String[] tickets = t.getTickets();

            if (index < 200) {
                String s = tickets[index];
                //模拟卖票过程  （遇到阻塞事件释放CPU时间片让其他线程操作，回到就绪状态抢夺CPU时间片,抢到之后继续执行之前的代码）
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--->卖出" + s);
                tickets[index] = null;
                index++;
            } else throw new TicketNullException("票已卖完");
        }
    }
}
