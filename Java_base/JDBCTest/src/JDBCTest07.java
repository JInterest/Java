import java.sql.*;
import java.util.Scanner;

/**
 * @author AJun
 * @version 1.0
 * @date 2020/4/26 14:01
 * JDBC事务机制
 */
public class JDBCTest07 {
    public static void main (String[] args){

        //执行SQL
        Connection conn= null;
        PreparedStatement ps=null;

        try{
            //1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2 连接驱动
            String url="jdbc:mysql://127.0.0.1:3306/mydbtest ?&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            String user="root";
            String password="root";
            conn = DriverManager.getConnection(url,user,password);
            //conn.setAutoCommit(false);//关闭自动提交，开启事务
            //3 获取数据库操作对象
            String sql="update t_act set balance=? where actno=?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count = ps.executeUpdate();

            String s=null;
            s.toString();

            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count  += ps.executeUpdate();
            System.out.println(count==2?"转帐成功":"转帐失败");

           // conn.commit();//提交事务
        }catch(Exception e){
            //出现异常 事务回滚
            /*try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }*/
            e.printStackTrace();
        }finally {

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
}
