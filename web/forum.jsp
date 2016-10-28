<%--
  Created by IntelliJ IDEA.
  temp.User: temp.User
  Date: 27.10.2016
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="thema" class="temp.Thema" scope="session"/>
<%

%>

<html>
<head>
    <title>Title</title>
</head>
<body>

Welcome to FORUM

<br>
<br>
<table border="1">
    <tr>
        <td>#</td>
        <td>Имя темы</td>
        <td>Количество соообщений</td>
    </tr>
    <c:forEach var="msg" items="${thema.messages}">
        <tr>
            <td>#</td>
            <td>${msg.text}</td>
            <td>${msg.avtor.firstName}${msg.avtor.lastName}<br>${msg.avtor.login}</td>
        </tr>
    </c:forEach>

</table>




</body>
</html>
