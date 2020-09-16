import java.sql.*;
//GBK
public class JDBCTest04{
	public static void main(String[] args){
	Connection conn=null;
	Statement stmt=null;
		try{
		//1 注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2 连接驱动
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest ?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
		//3 获取数据库操作对象
		stmt=conn.createStatement();
		//4 执行sql
		String sql = "delete from emp1 where empno=7499";
		int count = stmt.executeUpdate(sql);
		System.out.println(count == 1 ?"删除成功":"删除失败");
		//5 处理查询结果集
		
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
		//6 关闭资源
			try{
				if(stmt!=null){
				stmt.close();
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