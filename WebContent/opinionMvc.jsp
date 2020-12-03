<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="cukiernia, wypieki, słodycze">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Cukiernia Kremówka</title>
</head>
<%@include file="upperTemplate.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>

</body>
</html>
<table class="productTable">
    <thead>
    <tr>
        <td>Liczba</td>
        <td>Czy lubisz kremówki?</td>
        <td>Ulubiony kolor opakowania</td>
        <td>Email</td>
        <td>Opinia</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${opinions}" var="opinion">
    <tr>
        <td> ${opinion.number}</td>
        <td> ${opinion.like}</td>
        <td> ${opinion.color}</td>
        <td> ${opinion.email}</td>
        <td> ${opinion.opinion}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="lowerTemplate.jsp"%>
</html>