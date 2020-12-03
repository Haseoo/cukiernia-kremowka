<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 10.06.2020
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Podsumowanie zamówienia</title>
</head>
<body>
<h2>Poduskowanie zamówienia</h2>
<br>
<p>Produkt: <c:out value="${order.product}" escapeXml="false"/></p>
<br>
<p>Ilość <c:out value="${order.qty}" escapeXml="false"/></p>
<br>
<p>Dane kupującego: <c:out value="${order.personalInfo}" escapeXml="false"/></p>
</body>
</html>
