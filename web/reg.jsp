<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.10.2016
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>miniForum</title>
    <link href="forum.css" rel="stylesheet">
</head>
<body>

<br>
<table align="center">
    <tr>
        <td>
            <h1 align="center">miniForium</h1>


            <b  style="color: red">${param.error}</b>

            <form action="/login" method="get">
                <table align="center" >
                    <caption>
                        Регистрация
                    </caption>
                    <tr>
                        <td>Ваше имя</td>
                        <td><input type="hidden" name="act" value="new">
                            <input type="text" name="firstname"></td>
                    </tr>
                    <tr>
                        <td>Ваше фамилия</td>
                        <td><input type="text" name="lastname"></td>
                    </tr>
                    <tr>
                        <td>Логин</td>
                        <td><input type="text" name="login"></td>
                    </tr>

                    <tr>
                        <td>Пароль</td>
                        <td><input type="password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Регистрация"> </td>
                    </tr>
                </table>
                <a href="index.jsp">На главную</a>


            </form>


        </td>
    </tr>

</table>
</body>
</html>
