<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.03.2016
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page pageEncoding="UTF-8" language="java"  session="true" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Редактирование ролей</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css"/>
</head>
<body>
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}"
      method="post">
    <input type="submit"
           value="Log out"/>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<div class="center">
    <h1>Изменение ролей пользователей</h1>
    <table border="1">
        <tr>
            <th>Имя</th>
            <th>Действия</th>
        </tr>
        <c:forEach items="${roles}" var="role" varStatus="status">
            <tr valign="top">
                <td>${role.name}</td>
                <td>
                        <%--<form action=""></form>--%>
                    <a href="${pageContext.servletContext.contextPath}/admin/delete/${role.id}" method="GET">Удалить</a>
                    <a href="${pageContext.servletContext.contextPath}/admin/edit/${role.id}" method="GET">Редактировать</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>

    <form action="${pageContext.servletContext.contextPath}/admin/new" method="POST">
        Имя <input type="text" name="name" value="${role.name}"/>
        <input type="submit" align="center" value="Принять"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


</div>
</body>
</html>
