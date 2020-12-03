<%@ page import="pl.cukiernia.kremowka.model.OpinionModel" %>
<%@ page import="pl.cukiernia.kremowka.service.IOpinionService" %>
<%@ page import="pl.cukiernia.kremowka.service.OpinionService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private IOpinionService opinionService = new OpinionService();

%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="cukiernia, wypieki, słodycze">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Cukiernia Kremówka</title>
</head>
<!-- Dodaje górną część strony (z 1 laboratorium) do elementu body -->
<%@include file="upperTemplate.jsp"%>
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
    <% for(int i = 0; i < opinionService.getOpinions().size(); i++) {%>
    <% OpinionModel element = opinionService.getOpinions().get(i); %>
    <tr>
        <td> <%= element.getNumber()%></td>
        <td> <%= element.getDoLike()%></td>
        <td> <%= element.getColor()%></td>
        <td> <%= element.getEmail()%></td>
        <td> <%= element.getOpinion()%></td>
    </tr>
    <% } %>
    </tbody>
</table>
<!-- Dodaje dolną część strony (z 1 laboratorium), załącza skrypty JS, dodje stopkę -->
<%@include file="lowerTemplate.jsp"%>
</html>
