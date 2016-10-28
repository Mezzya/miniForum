<%--
  Created by IntelliJ IDEA.
  temp.User: temp.User
  Date: 27.10.2016
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="forum" class="temp.Forum" scope="session"/>
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
Добро пожаловать на форум <b>${activeuser.firstName} ${activeuser.lastName}</b>



            <table border="1" align="center" width="100%">
    <caption>
        Мини Форум
    </caption>
    <tr>
        <th>#</th>
        <th>Имя темы</th>
        <th align="center">Количество<br> соообщений</th>
        <th align="center">Автор</th>
    </tr>
    <c:forEach var="them" items="${forum.themas}" varStatus="thema">
        <tr>
            <td><a href="/viewthema?id=${thema.count}">${thema.count}</a></td>
            <td>${them.title}</td>
            <td align="center">${them.messages.size()}</td>
            <td align="center">${them.avtor.login}<br>${them.avtor.firstName} ${them.avtor.lastName}</td>

        </tr>
    </c:forEach>

</table>
<br><br>
            <b  style="color: red">${param.error}</b>
         <table width="100%">
             <caption>
                 Новая тема
             </caption>

             <tr>
                 <td>
                     <form action="/addthema" method="get">

                         Введите название:<br>
                         <input type="text" name="title" size="50">
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
