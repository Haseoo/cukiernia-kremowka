<%--
  Created by IntelliJ IDEA.
  User: dawid
  Date: 10.06.2020
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Zamowienie</title>
    <style>
        body{
            width: 20vw;
        }
        form{
            display: flex;
            flex-direction: column;
        }
        form input{
            margin-bottom: 20px;
        }
        button{
            width: 100px;
        }
    </style>
</head>
<body>
<form action="zamow" method="post">

    <label for="product"><b>Produkt</b></label>
    <input type="text" placeholder="Produkt" name="product" required>
    <label for="qty"><b>Ilosc</b></label>
    <input type="number" placeholder="Ilosc" name="qty" required>
    <label for="personalInfo"><b>Imie i nazwisko</b></label>
    <input type="text" placeholder="Imie i nazwisko" name="personalInfo" required>
    <button type="submit">Wyślij</button>
</form>
</body>
</html>
