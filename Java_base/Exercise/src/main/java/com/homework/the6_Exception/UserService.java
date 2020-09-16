package com.homework.the6_Exception;

public class UserService {
    String name;
    String  password;

    public UserService() {
    }
    //如果只在方法内部throw，而不在方法声明处throws，这种情况下，发生异常即抛出异常，终止程序。
    //如果在方法声明处throws，发生异常可以抛出到方法外，交给调用者来处理，调用者可以决定是throw还是try/catch。
    public void register(String username, String pw) throws IllegalNameException {
        // 引用类型==null这个判断最好写在所有条件的最前面，避免后面空指针异常
        if (null==username ||username.length()<=6 || username.length()>=16){
            /*System.out.println("用户名不合法，长度必须在[6-14]之间");
            return;*/
            throw new IllegalNameException("用户名不合法，长度必须在[6-14]之间");
        }
        System.out.println("注册成功,欢迎["+username+"]");
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
