<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020-08-21
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">

    用户名:<input type="text" name="username"/><br>
    密 码:<input type="password" name="password"/><br>
    <input type="submit" value="登录"/><br>
</form>


</body>
</html>
