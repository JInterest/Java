package com.test.dao;

import com.test.entity.Question;
import com.test.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/10  21:55
 */
public class QuDao {
    int result;
    Integer questionID;
    String title;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Question qu;

    public int add(Question qu){
        String sql ="insert into question(title,optionA,optionB,optionC,optionD,answer) value(?,?,?,?,?,?) ";
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,qu.getTitle());
            ps.setString(2,qu.getOptionA());
            ps.setString(3,qu.getOptionB());
            ps.setString(4,qu.getOptionC());
            ps.setString(5,qu.getOptionD());
            ps.setString(6,qu.getAnswer());
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null,ps,conn);
        }
        return result;
    }
    public List findAll(){
        List<Question> list =new ArrayList();
        String sql="select * from question";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                questionID=rs.getInt("questionID");
                title =rs.getString("title");
                optionA=rs.getString("optionA");
                optionB =rs.getString("optionB");
                optionC=rs.getString("optionC");
                optionD=rs.getString("optionD");
                answer=rs.getString("answer");
                qu=new Question(questionID,title,optionA,optionB,optionC,optionD,answer);
                list.add(qu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return  list;
    }
    public int delete(String questionID){
      String sql = "delete from question where questionID= ? ";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(questionID));
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return result;
    }
    public Question findById(String ID){
        String sql="select * from question where questionID = ?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(ID));
            rs=ps.executeQuery();
            while (rs.next()){
                questionID=rs.getInt("questionID");
                title=rs.getString("title");
                optionA=rs.getString("optionA");
                optionB=rs.getString("optionB");
                optionC =rs.getString("optionC");
                optionD =rs.getString("optionD");
                answer=rs.getString("answer");
                qu=new Question(questionID,title,optionA,optionB,optionC,optionD,answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return  qu;
    }
    public List sendTp(){
        List<Question> list =new ArrayList();
        String sql="select * from question order by rand() limit 0,4";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                questionID=rs.getInt("questionID");
                title =rs.getString("title");
                optionA=rs.getString("optionA");
                optionB =rs.getString("optionB");
                optionC=rs.getString("optionC");
                optionD=rs.getString("optionD");
                answer=rs.getString("answer");
                qu=new Question(questionID,title,optionA,optionB,optionC,optionD,answer);
                list.add(qu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return  list;
    }
    public int upDate(Question qu){
        String sql=" update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionID=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,qu.getTitle());
            ps.setString(2,qu.getOptionA());
            ps.setString(3,qu.getOptionB());
            ps.setString(4,qu.getOptionC());
            ps.setString(5,qu.getOptionD());
            ps.setString(6,qu.getAnswer());
            ps.setInt(7,qu.getQuestionID());
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return  result;
    }
}
