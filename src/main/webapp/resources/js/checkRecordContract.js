$(document).ready(function(){
	console.log("load");
	var sse = new EventSource('http://localhost:8080/test/contract/checkRecordBlockEvent.bsw');
	
	sse.onopen = function(event) {
		console.log("Connection Open!!!");
	}
	
	sse.onmessage = function (evt) {
	    console.log(evt.data);
	}
	
	sse.onerror = function(event){
		console.log(event.error);
	}
});
