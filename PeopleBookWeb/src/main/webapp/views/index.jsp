<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.03.2016
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Записная книжка</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css"/>
</head>
<body>
    <div>
        <h1>Главная страница приложения</h1>
        <form action="${pageContext.servletContext.contextPath}/user/abonent_list">
            <input type="submit" value="Перейти к списку абонентов"/>
        </form>

    </div>
<%--<jsp:include page="decor/header.jsp" flush="true"/>--%>
<%--<jsp:include page="decor/menu.jsp" flush="true"/>--%>
<%--<div id="content">содержимое</div>--%>
<%--<jsp:include page="decor/news.jsp" flush="true"/>--%>
<%--<jsp:include page="decor/footer.jsp" flush="true"/>--%>


</body>
</html>
