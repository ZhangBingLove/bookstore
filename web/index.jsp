<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    Date date = new Date();
    out.write(date.toLocaleString());
%>

</body>
</html>
