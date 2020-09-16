import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author AJun
 * @version 1.0
 * @date 2020/4/26 14:55
 * 测试DBUtil工具类
 */
public class JDBCTest08 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //1工具类加载注册驱动
            //2 连接驱动
            conn=DBUtil.getConnection();
            //3 获取数据库操作对象
            String sql="select ename from emp where ename like ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"_A%");
            //4 执行sql
            rs=ps.executeQuery();
            //5 处理结果集
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6 关闭资源
            DBUtil.close(rs,ps,conn);
        }
    }
}
