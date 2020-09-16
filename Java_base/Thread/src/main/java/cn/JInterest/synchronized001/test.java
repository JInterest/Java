package cn.JInterest.synchronized001;

public class test {
    public static void main(String[] args) {
        Account account=new Account("账户1",10000);
        Thread t1=new AccountThread(account);
        Thread t2=new AccountThread(account);

        t1.start();
        t2.start();
    }
}
