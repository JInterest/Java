public class Account {
    String userName;
    String password;

    public void set(String userName,String i) {
        this.userName = userName;
        this.password = i;
    }


    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password=" + password +
                '}';
    }
}
