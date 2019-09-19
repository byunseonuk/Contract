var webSocket;
var role;
var id;
$(document).ready(function(){
	webSocket = new WebSocket("ws://localhost:8080/test/wsCheckBlock.bsw");
	webSocket.onopen = onOpen;
	webSocket.onmessage = onMessage;
	webSocket.onclose = onClose;
	
	role = $('input[name="role"]').val();
	id = $('input[name="id"]').val();
	console.log(role);
	console.log(id);
});

function onOpen(event){
	console.log("연결됨~~~~");
	sendCheck();
}

function onMessage(event){
	console.log(event.data);
	if(event.data==="exists"){
		alert("확인하지 않은 블록에 기록된 계약이 있습니다.");
	}
}

function onClose(event){
	console.log("연결 끊김~~~");
}

function sendCheck(){
	var text = '{ "role":"'+role+'", "id":'+id+' }';
	//var jsonObject =  JSON.parse(text);
	webSocket.send(text);
}