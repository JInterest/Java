import java.sql.*;
import java.util.Scanner;

/**
 * @author AJun
 * @version 1.0
 * @date 2020/4/26 12:21
 */
//使用PreparedStatement出现以下情况：
// syntax to use near ''desc'' at line 1
public class JDBCTest06 {
    public static void main (String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("请输入desc或asc。desc表示降序，asc表示升序");
        System.out.print("请输入：");
        String keyWords = s.nextLine();

        //执行SQL
        Connection conn= null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            //1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2 连接驱动
            String url="jdbc:mysql://127.0.0.1:3306/mydbtest ?&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            String user="root";
            String password="root";
            conn = DriverManager.getConnection(url,user,password);
            //3 获取数据库操作对象
            stmt = conn.createStatement();
            //4 执行SQL
            String sql="select ename from emp order by ename "+keyWords;
            rs=stmt.executeQuery(sql);
            //5 处理查询结果集
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
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





















