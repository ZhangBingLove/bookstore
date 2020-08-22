<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020-08-21
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>home</title>
</head>
<body>

<c:if test="${empty u}">

    <a href="${pageContext.request.contextPath}/user/login.jsp">登录</a>
    <a href="${pageContext.request.contextPath}/user/register.jsp">注册</a><br>

</c:if>

<c:if test="${not empty u}">

    欢迎你: ${u.username} <a href="${pageContext.request.contextPath}/LoginOutServlet">注销</a>

</c:if>


</body>
</html>
