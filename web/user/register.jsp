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
    <title>register</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    用 户 名:<input type="text" name="username"/> ${uf.msg.username}<br>
    密 码:<input type="password" name="password"/>${uf.msg.password}<br>
    确认密码:<input type="password" name="repassword"/>${uf.msg.repassword}<br>
    邮 箱:<input type="text" name="email"/>${uf.msg.email}<br>
    生 日:<input type="text" name="birthday"/>${uf.msg.birthday}<br>
    <input type="submit" value="注册"/>

</form>


</body>
</html>
