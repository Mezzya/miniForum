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
<jsp:useBean id="activeuser" class="temp.User" scope="session"/>
<%

%>

<html>
<head>
    <title>miniForume</title>
    <link href="forum.css" rel="stylesheet">
</head>
<body>
<br>
<table align="center" width="80%">
    <tr>
        <td>
            <h1 align="center">miniFORUM</h1>

            <br>
            Добро пожаловать на форум <b>${activeuser.firstName} ${activeuser.lastName}</b>, <a href="index.jsp">Выйти</a>



            <table border="1" align="center" width="100%">
                <caption>
                    Мини Форум \
                </caption>
                <tr>
                    <th>#</th>
                    <th>${thema.title}</th>
                    <th>Время написания</th>>

                    <th align="center">${thema.avtor.login}</th>
                </tr>
                <c:forEach var="msg" items="${thema.messages}" varStatus="thema">
                    <tr>
                        <td>${thema.count}</td>
                        <td width="100%">${msg.text}</td>
                        <td>${msg.date}</td>
                        <td align="center">${msg.avtor.login}<br>${msg.avtor.firstName} ${msg.avtor.lastName}<br>${msg.avtor.colMsgplus()}</td>

                    </tr>
                </c:forEach>

            </table>
            <a href="forum.jsp">Вернутся к темам</a>
            <br><br>
            <b  style="color: red">${param.error}</b>
            <table width="100%">
                <caption>
                    Новое сообщение
                </caption>

                <tr>
                    <td>
                        <form action="/addmsg" method="get">
                            <input type="hidden" name="thema" value="${thema.title}">

                            Введите текс сообщения:<br>
                            <textarea name="message" cols="40" rows="3"></textarea><br><br>
                            <input type="submit" value="Создать">
                        </form>

                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>


</body>
</html>
