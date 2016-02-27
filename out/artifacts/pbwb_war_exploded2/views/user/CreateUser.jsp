<%--
  Created by IntelliJ IDEA.
  User: Shadoof
  Date: 26.02.2016
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/create" method="POST">
  <table>
    <tr>
      <td align="right">Логин : </td>
      <td>
        <input type="text" name = "login">
      </td>
    </tr>
    <tr>
      <td align="right">E-mail : </td>
      <td>
        <input type="text" name = "email">
      </td>
    </tr>
    <tr>
      <td><input type="submit" align="center" value="Принять"/></td>
    </tr>
  </table>
</form>
</body>
</html>
