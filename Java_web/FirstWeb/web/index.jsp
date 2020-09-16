<%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/5/3
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="page" var="key" value="第一个jstl表达"/>
输出当前页作用域对象key的值-->${pageScope.key}

