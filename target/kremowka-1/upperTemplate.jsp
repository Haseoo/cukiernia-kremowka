<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body onload="clock(); visitsCounter(); evInit();">
<header onclick="banerfun()">
</header>
<div class="mainContent">
    <aside>
        <div class="dropDownMenu" onclick="divSetVisible('info')">
            Informacje o cukierni
        </div>
        <div id="info">
            <ul class="linkList">
                <li class="linkPosition"><a href="#about" class="linkPosition">O cukierni</a></li>
                <li class="linkPosition"><a href="#products" class="linkPosition">Produkty</a></li>
                <li class="linkPosition"><a href="#productTable" class="linkPosition">Cennik</a></li>
            </ul>
        </div>
        <div class="dropDownMenu" onclick="divSetVisible('yourOpinion')">
            Twoja opinia
        </div>
        <div id="yourOpinion">
            <ul class="linkList">
                <li class="linkPosition"><a href="#opinion" class="linkPosition">Twoja opinia</a></li>
            </ul>
        </div>
        <div class="dropDownMenu" onclick="divSetVisible('theRest')">
            Reszta
        </div>
        <div id="theRest">
            <ul class="linkList">
                <li class="linkPosition"><a href="#video" class="linkPosition">Video</a></li>
            </ul>
        </div>

    </aside>
    <div class="contentOnRight">
        <nav>
            <div class="topMenuElement">
                <a href="index.html">Strona główna</a>
            </div>
            <div class="topMenuElement">
                <a href="galeria">Galeria</a>
            </div>
            <div class="topMenuElement">
                <a href="kontakt">Kontakt</a>
            </div>
            <div class="topMenuElement">
                <a href="opinie">Opinie</a>
            </div>
        </nav>
        <section>
