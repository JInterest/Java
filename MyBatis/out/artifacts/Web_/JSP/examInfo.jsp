<%@ page import="com.test.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 啊俊
  Date: 2020/5/12
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>


        <table align="center">
            <tr>
                <td>
                    班级:&nbsp;${className}&nbsp;姓名:${name}&nbsp;成绩:<font color="red">${score}</font>分
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
            </tr>

            <%
                int i=1;
                String answer,color,result;
                List<Question> list= (List<Question>) session.getAttribute("qu_sendTp");
                if (list==null || session.getAttribute("look")==null){
                    request.setAttribute("info","请先参加考试！");
                    request.getRequestDispatcher("/JSP/info.jsp").forward(request,response);
                    return;
                }
                for (Question qu:list
                ) {

                    if (request.getSession(false).getAttribute("uAnswer"+i) == null){
                        //未作答的情况
                        answer="";
                        color="red";
                        result="未作答，正确答案是:"+qu.getAnswer();
                    }else if (request.getSession(false).getAttribute("uAnswer"+i).equals(qu.getAnswer())){
                        //正确的情况
                        answer=qu.getAnswer();
                        color="";
                        result="";
                    }else{
                        //错误的情况
                        answer=(String)request.getSession(false).getAttribute("uAnswer"+i);
                        color="red";
                        result="错误，正确答案是:"+qu.getAnswer();
                    }
            %>

            <tr>
                <td>第<%=i%>题:<%=qu.getTitle()%>(<%=answer%>)<font color="<%=color%>"><%=result%></font> </td>
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
        </table>
</center>
</body>
</html>