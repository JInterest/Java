import java.util.ResourceBundle;

public class test {
    public static void main(String[] args) {
        //使用Java.util包下的资源绑定器 从配置文件中读取信息
        ResourceBundle rb = ResourceBundle.getBundle("class");
        String className =rb.getString("className");
        String userName = rb.getString("userName");
        String password = rb.getString("password");
        //测试反射类工具
        ReflectTest.refMethod(className,userName,password);

    }
}
