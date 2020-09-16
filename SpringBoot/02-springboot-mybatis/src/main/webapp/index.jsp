<%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/6/7
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>注册学生</h2>
    <form action="/student/add">
    <table >
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" name="注册">
                <input type="reset" name="重置">

            </td>
        </tr>
    </table>
    </form>
    <h2>删除学生</h2>
    <form action="/student/del">
    <table >
        <tr>
            <td>请输入要删除的学生学号</td>
        </tr>
        <tr>
            <td colspan="2">
            <input type="text" name="id">
            <input type="submit" name="删除">
            </td>
        </tr>
    </table>
    </form>
    <h2>查询学生信息</h2>
    <form action="/student/query">
        <table >
            <tr>
                <td>请输入要查询的学生学号</td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="text" name="id">
                    <input type="submit" name="查询">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
