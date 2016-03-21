<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.03.2016
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Создание пользователя</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css"/>
</head>
<body>
<div class="center">
    <c:if test="${create}">
        <h1>Создание нового пользователя</h1>
    </c:if>
    <c:if test="${!create}">
        <h1>Редактирование пользователя ${user.login}</h1>
    </c:if>
    <form:form action="${pageContext.servletContext.contextPath}/admin/new_user" method="post" commandName="user">
        <div>Логин: <form:input path="login"/></div>
        <div>E-mail: <form:input path="email"/></div>
        <div>
            Роль: <form:select path="role.id">
            <form:options items="${roles}" itemValue="id" itemLabel="name"></form:options>
        </form:select>
        </div>
        <div>Пароль: <form:input path="password"/></div>
        <div><input type="submit" align="center" value="Принять"/></div>
    </form:form>
</div>
</body>
</html>
