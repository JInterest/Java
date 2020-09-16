package cn.JInterest.except;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/29  14:08
 */
public class NotEnoughException extends RuntimeException {
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
