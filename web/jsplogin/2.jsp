<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020-08-20
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

结果是:
<%

    String name = request.getParameter("name");
    String age = request.getParameter("age");
    out.write(name);
    out.write(age);


    //        String p = (String) request.getAttribute("p");

//        String p = (String) session.getAttribute("p");

//    String p = (String) application.getAttribute("p");
%>
<%--<%= p%>--%>
<%--<%= pageContext.findAttribute("p")%>--%>

</body>
</html>
