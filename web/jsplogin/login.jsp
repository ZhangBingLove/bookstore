<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020-08-19
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>首页</title>
</head>


<body>

<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        out.write(msg);
    }
%>

<form action="/bookstore_war_exploded/DoLoginServlet" method="post">
    用户名: <input type="text" name="name"/><br>
    密 码: <input type="password" name="password"/><br>
    <input type="submit" value="登录"/>

</form>

</body>
</html>
