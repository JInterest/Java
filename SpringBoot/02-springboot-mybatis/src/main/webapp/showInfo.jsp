<%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/6/7
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  isELIgnored="false"%>
<html>
<head>
    <title>查询学生信息</title>
</head>
<body>
<div align="center">
    <table border="1">
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>邮箱</td>
        </tr>
        </thead>
        <tbody id="info">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.email}</td>
        </tr>
        </tbody>
    </table>

</div>
</body>
</html>
