function clock() {
    var currentdate = new Date(); 
    var datetime = timeFormat(currentdate.getDate()) + "/"
                    + timeFormat(currentdate.getMonth()+1)  + "/" 
                    + currentdate.getFullYear() + " "  
                    + timeFormat(currentdate.getHours()) + ":"  
                    + timeFormat(currentdate.getMinutes()) + ":" 
                    + timeFormat(currentdate.getSeconds());
           
        document.getElementById("zegar").innerHTML = datetime;
        setTimeout(clock, 500);
}

function timeFormat(time) {
    return ((time < 10) ? "0" + time : time);
}

function banerfun() {
    window.location.href = "http://localhost:2137/cukierniakremowka/index.html";
}

function myfun() {
    var liczba = document.getElementById("liczba").value;
    var kremowka = ""; 
    document.getElementsByName("kremowka").forEach(element => {
    	if(element.checked){
    		kremowka = element.value;
    	}
    });
    var kolor = document.getElementById("kolor").value;
    var email = document.getElementById("email").value;
    var opinia = document.getElementById("opinia").value;
    
    var json = {"number": liczba, "doLike": kremowka, "color": kolor, "email": email, "opinion": opinia};
    
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        if (this.readyState == 4) {
            var formResult = document.getElementById("formResult");
            formResult.style.height = "auto";
            var rStatus = this.status;
            if (rStatus == 200 || rStatus == 401 || rStatus==500) {
                formResult.innerText = this.responseText;
            } else {
                formResult.innerText = "Nie udało się dodać opinii";
            }
            setTimeout(removeStateDiv, 7000);
        }
    }

    function removeStateDiv() {
        document.getElementById("formResult").style.height = "0";
    }
    
    request.open("POST", "opinie");
    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    request.send(JSON.stringify(json));
    
    if (btoa(liczba) == "MjEzNw==") {
        var myMusic= document.getElementById("music");
        myMusic.play();
    }
}
function tak() {
     var myMusic= document.getElementById("musicTak");
     myMusic.play();
}
function nie() {
     var myMusic= document.getElementById("musicNie");
     myMusic.play();
}
function nieWiem() {
     var myMusic= document.getElementById("musicNieWiem");
     myMusic.play();
}

function divSetVisible(elementId) {
    var element = document.getElementById(elementId);
    if (element.style.maxHeight) {
		element.style.maxHeight  = null;
		element.style.transition = "all 0.8s cubic-bezier(0, 1.05, 0, 1)";
    } else {
        element.style.maxHeight = "500px";
		element.style.transition = "all 0.8s linear";
    }
}

function evInit() {
    document.addEventListener('keydown', (event) => {
        if (event.key == 'd') {
        }
        switch (event.key) {
            case 'd' : 
                changeCSS("style-dark.css", 0);
                break;
            case 'w' :
                changeCSS("style-white.css", 0);
                break;
        }
    }, false);
}

function changeCSS(cssFile, cssLinkIndex) {

    var oldlink = document.getElementsByTagName("link").item(cssLinkIndex);

    var newlink = document.createElement("link");
    newlink.setAttribute("rel", "stylesheet");
    newlink.setAttribute("type", "text/css");
    newlink.setAttribute("href", cssFile);

    document.getElementsByTagName("head").item(0).replaceChild(newlink, oldlink);
}

function visitsCounter(){
	var counter = Number(localStorage.getItem("visits"));
	if(counter){
		counter += 1;
	} else {
		counter = 1;
	}
	localStorage.setItem("visits", counter);
	document.getElementById("visits").innerHTML = counter;
}




