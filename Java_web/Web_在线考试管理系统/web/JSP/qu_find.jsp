<%@ page import="com.test.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/5/10
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        input{
            border: none;
            overflow: hidden;
            height: 100%;
            width: 100%;
        }
    </style>
</head>
<body>
<center>
    <form action="/myWeb/qu_add" method="get">
        <%
            List<Question> list=(List<Question>) request.getAttribute("qu_find");
        %>
        <table border="2">

            <tr>
                <th>试题编号</th>
                <th>试题信息</th>
                <th>A选项</th>
                <th>B选项</th>
                <th>C选项</th>
                <th>D选项</th>
                <th>正确答案</th>
                <th colspan="2">操作</th>
            </tr>

                <%
                    for (Question qu:list
                    ) {

                %>
                <tr>
                <td><input type="text" name="questionID" value="<%=qu.getQuestionID()%>" readonly></td>
                <td><input type="text" name="title" value="<%=qu.getTitle()%>"></td>
                <td><input type="text" name="optionA" value="<%=qu.getOptionA()%>"></td>
                <td><input type="text" name="optionB" value="<%=qu.getOptionB()%>"></td>
                <td><input type="text" name="optionC " value="<%=qu.getOptionC()%>"></td>
                <td><input type="text" name="optionD" value="<%=qu.getOptionD()%>"></td>
                <td><input type="text" name="answer" value="<%=qu.getAnswer()%>"></td>
                <td><a href="/myWeb/qu_del?questionID=<%=qu.getQuestionID()%>" />删除试题</td>
                <td><a href="/myWeb/qu_findById?questionID=<%=qu.getQuestionID()%>" /> 查看详细</td>
                </tr>
                <%
                    }
                %>

        </table>
    </form>
</center>
</body>
</html>
