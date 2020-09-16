<%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/5/10
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String result=(String) request.getAttribute("info");
%>
    <center>
        <font size="45px" color="#1e90ff"><%=result%></font>
    </center>

