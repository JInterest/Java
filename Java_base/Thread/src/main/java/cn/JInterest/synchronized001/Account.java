package cn.JInterest.synchronized001;

/**
 * 模拟银行账户
 */

public class Account {
    private String actName;
    private double balance;

    public Account() {
    }

    public Account(String actName, double balance) {
        this.actName = actName;
        this.balance = balance;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double money) {
        //线程同步机制  同步代码块里面代码越少效率越高
        synchronized (this) {//(共享的对象)
            double before = this.balance;
            double after = before - money;
            //发生网络延迟
           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            this.setBalance(after);
        }
    }
}
