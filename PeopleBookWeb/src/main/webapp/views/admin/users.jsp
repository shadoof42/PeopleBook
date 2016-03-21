<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.03.2016
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Редактирование пользователей</title>
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
    <h1>Изменение пользователей</h1>
    <table border="1">
        <tr>
            <th>Логин</th>
            <th>e-mail</th>
            <th>Роль</th>
            <th>Действия</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr valign="top">
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.role.name}</td>
                <td>
                        <%--<form action=""></form>--%>
                    <a href="${pageContext.servletContext.contextPath}/admin/user_delete/${user.id}" method="GET">Удалить</a>
                    <a href="${pageContext.servletContext.contextPath}/admin/user_edit/${user.id}" method="GET">Редактировать</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>

    <form action="${pageContext.servletContext.contextPath}/admin/new_user" method="GET">
        <%--Имя <input type="text" name="name" value="${user.name}"/>--%>
        <input type="submit" align="center" value="Создать нового пользователя"/>

        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    </form>
</div>
</body>
</html>
