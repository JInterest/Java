package com.test.entity;

public class Users {
    private Integer userID;
    private String userName;
    private String password;
    private String sex;
    private String email;


    public Users() {
    }

    public Users(Integer userID, String userName, String passWord, String sex, String email) {
        this.userID = userID;
        this.userName = userName;
        this.password = passWord;
        this.sex = sex;
        this.email = email;
    }
    public Users(Integer userID, String userName,  String sex, String email) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.email = email;
    }
    public Users(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
