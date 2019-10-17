var webSocket = new WebSocket('ws://localhost:8080/cryptosnack-websocket');

var stomp = null;
// webSocket.onopen = function() {
// //         webSocket.send(JSON.stringify({"command": "subscribe","identifier":"{\channel\"}))
// //         }

//TODO remove me, I won't be needed since I am always there, this is the conversation table.
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#chat").html("");
}

function connect() {
    var socket = new SockJS('/cryptosnack-websocket');
    stomp = Stomp.over(socket);
    stomp.connect({}, function(frame){
        setConnected(true);
        stomp.subscribe('/topic/messages', function(data) {
            showNewMessage(data);
        });
    });
}

function showNewMessage(message) {
    $("#chat").append("<tr><td>" + JSON.parse(message.body).message + "</td></tr>");
    // + "<tr><td>" + +"</td></tr>");
}

function sendMessage() {
    // console.log("sendName(): " + JSON.stringify({'message': $("#chatInput").val()}));
    stomp.send("/app/chat", {}, JSON.stringify({'message': $("#chatInput").val()}));
}

// Behövs detta? Disconnectar den inte auto?
// function disconnect() 1{
//
// }

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#send" ).click(function() {sendMessage();});
    connect();
});