package DBUtil;

import java.sql.*;

public class DBUtil {
    /**
     * ������Ĺ��췽������˽�еġ�
     * ��Ϊ�����൱�еķ������Ǿ�̬�ģ�����Ҫnew����ֱ�Ӳ�����������
     */
    private DBUtil(){}
    //��̬������������ʱִ�У�����ִ��һ�Ρ�
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //��ȡ���ݿ����Ӷ���
    public static Connection getConnection() throws Exception{
        String url="jdbc:mysql://127.0.0.1:3306/mydbtest ?&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String user="root";
        String password="root";

        return DriverManager.getConnection(url,user,password);
    }
    /**
     *�ر���Դ
     * @param conn ���Ӷ���
     * @param ps    ���ݿ��������
     * @param rs    �����
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
