package cn.JInterest.demo12306;
//车票为空异常
public class TicketNullException extends Exception{
    public TicketNullException() {
    }

    public TicketNullException(String message) {
        super(message);
    }
}
