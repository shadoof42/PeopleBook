<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.03.2016
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Редактирование роли</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css"/>
</head>
<body>
<div align="center">
    <p>Старое имя роли: ${role.name} его id: ${role.id}</p>
    <form:form action="${pageContext.servletContext.contextPath}/admin/edit/${role.id}" commandName="role" method="POST">
    Новое имя: <form:input path="name"></form:input>
    <input type="submit" align="center" value="Принять"/>
</form:form>

</div>
</body>
</html>
