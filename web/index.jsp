<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.10.2016
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <b style="color: red">${param.login}</b>

  <h1>Please login</h1>
  <form action="/login" method="get">
    <table border="1">
     <tr>
       <td>Login</td>
       <td><input type="text" name="name"></td>
     </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="password">
        </td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit"></td>
      </tr>
    </table>


  </form>

  $END$
  </body>
</html>
