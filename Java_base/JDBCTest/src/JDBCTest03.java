import java.sql.*;
import java.util.ResourceBundle;
//使用配置文件
public class JDBCTest03 {
	public static void main(String[] args){
		ResourceBundle rb=ResourceBundle.getBundle("jdbc");
		String className=rb.getString("className");
		String url=rb.getString("url");
		String user=rb.getString("user");
		String password=rb.getString("password");

		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
			//1 注册驱动 Driver
			Class.forName(className);
			//2 连接驱动
			conn = DriverManager.getConnection(url,user,password);
			//3 获取数据库操作对象
			stat = conn.createStatement();
			//4 执行sql
			String sql = "select ename,job,sal from emp";
			//5 处理查询结果
			rs = stat.executeQuery(sql);
			while (rs.next()){
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				String sal=rs.getString("sal");
				System.out.println(ename+","+job+","+sal);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			//6 释放资源
			try{
				if(rs!=null){
					rs.close();
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(stat!=null){
					stat.close();
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(conn!=null){
					conn.close();
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}


















