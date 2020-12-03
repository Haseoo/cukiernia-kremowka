<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 10.06.2020
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witaj w super secret panelu</title>
</head>
<br>
    <p>
        Zalogowano jako
        <span>
            <c:out value="${cUser}" escapeXml="false"/>
        </span>
    </p>
    <br>
    <a href="cLogout">Wyloguj</a>
</body>
</html>
