<%--
  Created by IntelliJ IDEA.
  temp.User: temp.User
  Date: 27.10.2016
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <link href="forum.css" rel="stylesheet">
  </head>
  <body>

<br>
<table align="center">
<tr>
    <td>
        <h1 align="center">miniForum</h1>


        <b  style="color: red">${param.error}</b>

        <form action="/login" method="get">
            <table align="center">
            <caption>
                Вход на форум
            </caption>
                <tr>
                    <td>Логин</td>
                    <td><input type="hidden" name="act" value="login">
                        <input type="text" name="login"></td>
                </tr>
                <tr>
                    <td>Пароль</td>
                    <td><input type="password" name="password">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Ввойти"> <a href="reg.jsp">Регистрация</a> </td>
                </tr>
            </table>


        </form>


    </td>
</tr>

</table>
  </body>
</html>
