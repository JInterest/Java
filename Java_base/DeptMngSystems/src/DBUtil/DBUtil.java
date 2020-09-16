package DBUtil;

import java.sql.*;

public class DBUtil {
    /**
     * 工具类的构造方法都是私有的。
     * 因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用
     */
    private DBUtil(){}
    //静态代码块在类加载时执行，并且执行一次。
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取数据库连接对象
    public static Connection getConnection() throws Exception{
        String url="jdbc:mysql://127.0.0.1:3306/mydbtest ?&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String user="root";
        String password="root";

        return DriverManager.getConnection(url,user,password);
    }
    /**
     *关闭资源
     * @param conn 连接对象
     * @param ps    数据库操作对象
     * @param rs    结果集
     */
    public static void close(ResultSet rs,Statement ps,Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
