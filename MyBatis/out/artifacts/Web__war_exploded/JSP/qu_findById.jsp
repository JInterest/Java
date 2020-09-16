<%@ page import="com.test.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/5/11
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
<center>
    <%
        Question qu= (Question) request.getAttribute("qu_findById");
    %>
    <form action="/myWeb/qu_update" method="get">
        <table border="2">
            <input type="text" name="questionID" value="<%=qu.getQuestionID()%>" hidden>
            <tr>
                <th>题目</th>
                <td><input type="text" name="title"  value="<%=qu.getTitle()%>"></td>
            </tr>
            <tr>
                <th>A:</th>
                <td><input type="text" name="optionA" value="<%=qu.getOptionA()%>"></td>
            </tr>
            <tr>
                <th>B:</th>
                <td><input type="text" name="optionB" value="<%=qu.getOptionB()%>"></td>
            </tr>
            <tr>
                <th>C:</th>
                <td><input type="text" name="optionC" value="<%=qu.getOptionC()%>"></td>
            </tr>
            <tr>
                <th>D:</th>
                <td><input type="text" name="optionD" value="<%=qu.getOptionD()%>"></td>
            </tr>
            <tr>
                <th>正确答案:</th>
                <td>
                    <%String answer=qu.getAnswer();%>
                    <input type="radio" name="answer" value="A" <%="A".equals(answer)?"checked":""%> >A
                    <input type="radio" name="answer" value="B" <%="B".equals(answer)?"checked":""%> >B
                    <input type="radio" name="answer" value="C" <%="C".equals(answer)?"checked":""%> >C
                    <input type="radio" name="answer" value="D" <%="D".equals(answer)?"checked":""%> >D
                </td>
            </tr>
            <tr >
                <td align="center" colspan="2">
                    <input type="submit"  value="更改">&nbsp;&nbsp;&nbsp;
                    <input type="reset"  value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>