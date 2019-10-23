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
    $("#chat").append("<tr><td class='td-date'>" + JSON.parse(message.body).timeSent +"</td>" +
        "<td class='td-user'>" + JSON.parse(message.body).sentFrom +":</td>" +
        "<td class='td-message'>" + JSON.parse(message.body).message + "</td></tr>");
}

function sendMessage() {
    // console.log("sendName(): " + JSON.stringify({'message': $("#chatInput").val()}));
    stomp.send("/app/chat", {}, JSON.stringify({'message': $('#chatInput').val(), 'sentFrom' : $('#user_h3').text()}));
    $('#chatInput').val('');
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#send" ).click(function() {sendMessage();});
    connect();
});