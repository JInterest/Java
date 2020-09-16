package cn.JInterest.method.wait_notify;

public class test {
    public static void main(String[] args) {
        Amount amount=new Amount();
        Thread t1=new Thread01(amount);
        Thread t2=new Thread02(amount);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
