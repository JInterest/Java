/*
JDBC 编程六步
*/

import java.sql.*;

public class JDBCTest01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //1 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2 连接驱动
            String url = "jdbc:mysql://127.0.0.1:3306/mydbtest ?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            //3 获取数据库操作对象（Statement专门执行sql语句的）
            stat = conn.createStatement();
            //4 执行sql
            String sql = "insert into dept(deptno,dname,loc) values(50,'人事部','北京')";
            //专门执行DML语句的（insert，delete，update）
            //返回值是 “影响数据库中的记录条数”
            int count = stat.executeUpdate(sql);
            System.out.println(count == 1 ? "保存成功" : "保存失败");
            //5 处理查询结果
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6 释放资源
            //为了保证资源一定释放，在finally 语句块中关闭资源
            //并且要遵循从小到大依次关闭
            //分别对其try..catch
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}



















