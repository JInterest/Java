import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * @author AJun
 *1、需求：
 * 		模拟用户登陆功能的实现。
 *2、业务描述：
 * 		程序运行的时候，提供一个输入的人口，可以让用户输入用户名和密码
 * 		用户输入用户名和密码之后，提交信息，Java程序收集到用户信息
 * 		Java程序连接数据库验证用户名和密码是否合法
 * 		合法：显示成功   不合法：显示失败
 * 3、数据的准备：
 * 		参见 user-login.sql教本。
 * 4、当前程序出现的问题：
 * 		密码：sad' or '1'='1
 * 		SQL注入（安全隐患）
 *5、导致SQL注入的根本原因是什么？
 * 		用户输入的信息中含有sql语句的关键字，并且这些关键字参与sql语句的编译过程，
 * 		导致sql语句的愿意被扭曲，进而达到sql注入。
 *6、解决SQL注入问题？
 * 		只要用户提供的信息不参与SQl语句的编译过程，问题就解决了。
 * 		即使用户提供的信息中含有SQL语句的关键字，但是没有参加编译，不起作用。
 * 		要想用户信息部参与SQL语句的编译，那么必须使用Java.sql.PreparedStatenebt
 * 		Java.sql.PreparedStatenebt接口继承了Java.sql.Statenebt是属于预编译的
 * 		数据库操作对象。原理是：预先对SQL语句的框架进行编译，然后再给SQL语句穿“值”。
 *7、对比Statement和PreparedStatement
 * 		-Statement是编译一次执行一次。PreparedStatement是编译一次，可执行N次。PreparedStatement效率较高
 *		-PreparedStatement会在编译阶段做类型的安全检查。
 *	只有业务方面要求必须支持注入SQL，进行SQl语句拼接的时候才用 Statement。
 *	升序降序  order by xxx asc  如果用ps 	ps.setString(1,"asc");  会变成'asc'  -->JDBCTest06
 */
public class JDBCTest05{
	public static void main(String[] args){
		//初始化一个界面
		Map<String,String> userLoginInfo= initUI();
		//验证用户名和密码
		boolean loginSuccess = login(userLoginInfo);
		//输出最后结果
		System.out.println(loginSuccess ? "登陆成功":"登陆失败");
	}
	/**
	 *验证用户名和密码
	 *@return true表示成功 false表示失败
	 */
	public static boolean login(Map<String,String> map){
		boolean flag=false;
		//jdbc代码
		Connection conn=null;
		//Statement stmt=null;
		PreparedStatement ps=null;//这里使用预编译的数据库操作对象
		ResultSet rs=null;
		
		String loginName=map.get("loginName");
		String loginPwd=map.get("loginPwd");
		
		try{
		//1 注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2 连接驱动
		String url="jdbc:mysql://127.0.0.1:3306/mydbtest ?&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
		String user="root";
		String password="root";
		conn=DriverManager.getConnection(url,user,password);
		//3 获取预编译的数据库管理对象
		//SQL的框子。其中一个？ 代表一个占位符，将来接受一个“值”，注意占位符不能使用单引号括起来。
		String sql = "select * from t_user where LoginName=? and LoginPwd=?";
		//程序执行到此，会发送SQL语句的框子给DBMS，然后DBMS进行SQL语句的预先编译。
		ps=conn.prepareStatement(sql);
		//给占位符传值，JDBC中所有下标从1开始。
		ps.setString(1,loginName);
		ps.setString(2,loginPwd);
		//4 执行sql
		//String sql = "select * from t_user where LoginName='"+loginName+"' and LoginPwd='"+loginPwd+"'?''";
		//以上正好完成了sql语句的拼接，以下代码的含义是，发送sql语句给DBMS，DBMS进行编译。
		//正好将用户提供的”非法信息“编译进去。导致了原sql语句的含义被扭曲了。
		rs=ps.executeQuery();
		//5 处理查询结果
		if(rs.next()){
		//登陆成功
			flag=true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//6 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	/**
	 *初始化用户界面
	 *@return 用户输入的用户名和密码等登陆信息
	 */
	public static Map<String,String> initUI(){
		Scanner s = new Scanner(System.in);
		
		System.out.print("请输入用户名:");
		String loginName = s.nextLine();
		
		System.out.print("请输入密码:");
		String loginPwd = s.nextLine();
		
		Map<String,String> userLoginInfo = new HashMap<>();
		userLoginInfo.put("loginName",loginName);
		userLoginInfo.put("loginPwd",loginPwd);
		
		return userLoginInfo;
	}
}

