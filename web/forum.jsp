<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.10.2016
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

%>

<html>
<head>
    <title>Title</title>
</head>
<body>

Welcome to FORUM
${param.name}
<%
 out.print("HELLO!!!");

%>

<c:forEach var="user" items="${thema}">
    <c:out value="${user.name}"/>

</c:forEach>




</body>
</html>
