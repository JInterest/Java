package DAO;

import DBUtil.DBUtil;
import DeptMngSystems.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

/**
 * @author AJun
 * @version 1.0
 * @date 2020/5/1 20:25
 * 利用dao层将数据库操作都封装起来。
 *
 * 1、隔离了数据访问代码和业务逻辑代码。业务逻辑代码直接调用DAO方法即可，完全感觉不到数据库表的存在。
 * 分工明确，数据访问层代码变化不影响业务逻辑代码,这符合单一职能原则，降低了藕合性，提高了可复用性。
 *
 * 2、隔离了不同数据库实现。采用面向接口编程，如果底层数据库变化，如由 MySQL 变成 Oracle 只要增加 DAO 接口的新实现类
 *   即可，原有 MySQL 实现不用修改。这符合 "开-闭" 原则。该原则降低了代码的藕合性，提高了代码扩展性和系统的可移植性。
 */
//封装dept表的细节操作
public class DeptDao {
    private Connection conn = null;
    private PreparedStatement ps=null;
    private int result=0;
    private ResultSet rs=null;

    //增
    public int add(String deptno,String dname,String loc){
        String sql_add= "insert into  dept(deptno,dname,loc) value(?,?,?) ";
        try {
            //注册驱动 ，连接驱动，获取数据库操作对象ps
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql_add);
            ps.setInt(1,Integer.parseInt(deptno));
            ps.setString(2,dname);
            ps.setString(3,loc);
            //执行sql
            result=ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return result;
    }
    //删
    public int del(String deptno){
        String sql_del="delete from dept where deptno=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql_del);
            ps.setInt(1,Integer.parseInt(deptno));
            //执行sql
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return result;
    }
    //改
    public int update (String deptno,String dname,String loc ){
        String sql_update="update dept set dname=?,loc=? where deptno=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql_update);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setInt(3,Integer.parseInt(deptno));
            //执行sql
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return result;
    }
    //查
    public List select (){
        String sql_select ="select * from dept";
        //释放结果集前 把实体类对象放入集合中
        List<Dept> list=new ArrayList();
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql_select);
            //执行sql
            rs=ps.executeQuery();
            //遍历结果集 将数据放入list中
            while (rs.next()){
                int deptno=rs.getInt("deptno");
                String dname=rs.getString("dname");
                String loc=rs.getString("loc");
                Dept dept=new Dept(deptno,dname,loc);
                list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return list;
    }
    //验证
    public int Verify (String dname,String deptno){
        int count=0;
        String sql_verify ="select count(*) from dept where dname=? and deptno=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql_verify);
            ps.setString(1,dname);
            ps.setString(2,deptno);
            rs=ps.executeQuery();
            while (rs.next()){
                count=rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return count;
    }
}
