package cn.JInterest.synchronized001;

/*
            条件1：多线程并发。
			条件2：有共享数据。
			条件3：共享数据有修改的行为。

		满足以上3个条件之后，就会存在线程安全问题。
*/
public class AccountThread extends Thread{
    private Account act;

    public AccountThread(Account act) {
        this.act = act;
    }

    public void run(){
        double money =5000;
        /*synchronized (act){
            act.withdraw(money);
        }*/
        act.withdraw(money);

        System.out.println(Thread.currentThread().getName()+"从"+act.getActName()+"取款"+money+"成功，余额"+act.getBalance());

    }

}
