package com.test.dao;


import com.test.entity.Users;
import com.test.util.DBUtil;


import javax.servlet.http.HttpServletRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/04  17:26
 */
public class UserDao {
    private Connection conn = null;
    private PreparedStatement ps=null;
    private int result=0;
    private ResultSet rs=null;
    //-------------使用监听器提前创建的Connection-------------
    public int add(Users users,HttpServletRequest request){
        String sql="insert into users(userName,password,sex,email) value (?,?,?,?)";
        try {
            //从全局作用域获取数据库连接对象
            conn=DBUtil.getConnection(request);
            //获取数据库操作对象
            ps=conn.prepareStatement(sql);
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassWord());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            //执行sql
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null,ps,conn,request);
        }
        return result;
    }
    //-------------使用监听器提前创建的Connection-------------

    //用户注册
    public int add(Users users){
        String sql="insert into users(userName,password,sex,email) value (?,?,?,?)";
        try {
            //获取数据库连接对象
            conn=DBUtil.getConnection();
            //获取数据库操作对象
            ps=conn.prepareStatement(sql);
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassWord());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            //执行sql
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null,ps,conn);
        }
        return result;
    }
    //用户查询
    public List select(){
        String sql ="select * from users ";
        List<Users> usersList=new ArrayList<>();
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Integer userid=rs.getInt("userid");
                String userName=rs.getString("userName");
                String password=rs.getString("password");
                String sex = rs.getString("sex");
                String email=rs.getString("email");

                usersList.add(new Users(userid,userName,password,sex,email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return usersList;
    }
    //更新用户信息
    public int upDate(Users users){
        String sql = "update users set userName=?,sex=?,email=? where userid=?";
        int result=0;
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getSex());
            ps.setString(3,users.getEmail());
            ps.setInt(4,users.getUserID());
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return result;
    }
    //登录验证用户信息
    public int login(String userName,String password){
        String sql ="select count(*) from users where userName=? and password=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while (rs.next()){
                result=rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return result;
    }
    //删除用户
    public int delete(String userid){
        String sql="Delete from users where userid=?";
        int id=Integer.valueOf(userid);
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return result;
    }
    //根据用户名查找信息
    public int findByName(String userName){
        String sql="select * from users where userName=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,userName);
            rs=ps.executeQuery();
            while (rs.next()){
                result++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null,ps,conn);
        }
        return result;
    }
}
