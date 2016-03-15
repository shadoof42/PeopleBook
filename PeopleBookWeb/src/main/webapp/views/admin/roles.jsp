<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.03.2016
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page pageEncoding="UTF-8" language="java"  session="true" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<fmt:requestEncoding value="UTF-8" />--%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>Редактирование ролей</title>
    <%--<meta name="_csrf" content="${_csrf.token}"/>--%>
    <%--<!-- default header name is X-CSRF-TOKEN -->--%>
    <%--<meta name="_csrf_header" content="${_csrf.headerName}"/>--%>
  <!-- ... -->
</head>
<%--<div></div>--%>
<h1>Изменение ролей пользователей</h1>
  <table border="1">
    <tr>
      <td>Имя</td>
      <td>Действия</td>
    </tr>
    <c:forEach items="${roles}" var="role" varStatus="status">
      <tr valign="top">
        <td>${role.getName()}</td>
        <td>Удалить Редактировать</td>
      </tr>
    </c:forEach>
  </table><br/>
  <form action="${pageContext.servletContext.contextPath}/admin/new" method="POST">
    Имя <input type = "text" name="name" value="${user.login}" >
    <input type="submit" align="center" value="Submit"/>
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
  </form>
  <h2>   </h2>
  <c:url var="logoutUrl" value="/logout"/>
  <form action="${logoutUrl}"
        method="post">
    <input type="submit"
           value="Log out" />
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
  </form>
</body>
</html>
