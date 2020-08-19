<%--
  Created by IntelliJ IDEA.
  User: 章冰
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

欢迎您: <%
    String name = (String) session.getAttribute("name");
    if (name != null && !name.isEmpty()) {
        out.write(name);
    }
%>
<a href="/bookstore_war_exploded/jsplogin/home.jsp">跳到主页</a>

</body>
</html>
