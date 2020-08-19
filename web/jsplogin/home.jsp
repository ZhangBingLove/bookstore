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
<h1>欢迎来到本网站</h1>
欢迎您: <%
    String name = (String) session.getAttribute("name");
    if (name != null && !name.isEmpty()) {
        out.write(name);
    }

%>

</body>
</html>
