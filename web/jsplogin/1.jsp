<%@ page import="com.test.project.jsp.Student" %><%--
  Created by IntelliJ IDEA.
  UserDao: mac
  Date: 2020-08-20
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--测试四大域 pagerContext request session application  --%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<%--%>

<%--    Student student = new Student();--%>
<%--    student.setName("张三");--%>
<%--    student.setAge("20");--%>

<%--    out.write(student.getName());--%>
<%--%>--%>


<%--<jsp:useBean id="student" class="com.test.project.jsp.Student"/>--%>
<%--<jsp:setProperty name="student" property="age" value="tome"/>--%>
<%--<jsp:setProperty name="student" property="age" value="30"/>--%>
<%--<jsp:getProperty name="student" property="name"/>--%>

<jsp:forward page="/jsplogin/2.jsp">
    <jsp:param name="name" value="tom"/>
    <jsp:param name="age" value="20"/>
</jsp:forward>


<%--<%--%>

<%--    pageContext.setAttribute("p", "pageContext");--%>

<%--    request.setAttribute("p", "request");--%>

<%--    session.setAttribute("p", "session");--%>

<%--    application.setAttribute("p", "application");--%>

<%--//    request.getRequestDispatcher("/jsplogin/2.jsp").forward(request, response);--%>

<%--//    response.sendRedirect(request.getContextPath() + "/jsplogin/2.jsp");--%>

<%--%>--%>


</body>
</html>
