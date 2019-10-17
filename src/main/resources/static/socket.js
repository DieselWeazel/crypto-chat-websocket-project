var stomp = null;

function connect() {
    var socket = new SockJS('/cryptosnack-websocket');
    stomp = Stomp.over(socket);
    stomp.connect({}, function(frame){
        // setConnected(true);
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

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#send" ).click(function() {sendMessage();});
    connect();
});