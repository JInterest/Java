<%@ page import="java.util.List" %>
<%@ page import="com.test.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/5/11
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>

    <form action="/myWeb/qu_exam">
        <table align="center">
            <tr>
                <td>
                    班级:<input type="text" name="className">&nbsp;姓名:<input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
            </tr>

            <%
                int i=1;
                List<Question> list= (List<Question>) session.getAttribute("qu_sendTp");
                for (Question qu:list
                ) {
            %>
            <tr>
                <td>第<%=i%>题:<%=qu.getTitle()%>(<input type="text" style="width: 15px;border: none;" name="uAnswer_<%=qu.getQuestionID()%>" >)</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;A:<%=qu.getOptionA()%></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;B:<%=qu.getOptionB()%></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;C:<%=qu.getOptionC()%></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;D:<%=qu.getOptionD()%></td>
            </tr>

            <%
                    i++;
                }
            %>
            <tr>
                <td align="center">
                    <input type="submit" value="交卷">&nbsp;&nbsp;&nbsp;
                    <input type="reset">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
