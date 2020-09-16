<%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/5/15
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <form action="${pageContext.request.contextPath}/up" method="post" enctype="multipart/form-data">
      <input type="file" name="myFile"><br>
      <input type="submit" value="上传文件">
    </form>
   <form action="${pageContext.request.contextPath}/download" method="get" enctype="multipart/form-data">
        <p>
       <input type="text" name="file"><br>
       <input type="submit" value="下载文件">
   </form>
  </body>
</html>
