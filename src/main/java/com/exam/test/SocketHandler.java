package com.exam.test;

import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.exam.test.model.AuthInfoVO;
import com.exam.test.service.ContractService;

public class SocketHandler extends TextWebSocketHandler{
	
	@Autowired
	ContractService contractService;
	
	private Set<WebSocketSession> webSocketSession = new HashSet<WebSocketSession>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		webSocketSession.remove(session);
		System.out.println("Remove Session!");
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		webSocketSession.add(session);
		System.out.println("Add Session!!");
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println(exception.getMessage());
	}
	
//	@Override 
//	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//		super.handleMessage(session, message);
//		System.out.println("receive message:"+message.toString());
//		
//	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		JSONParser parser = new JSONParser();
		JSONObject j = (JSONObject)parser.parse(message.getPayload());
		AuthInfoVO info = new AuthInfoVO();
		info.setRole(j.get("role").toString());
		info.set_id((int)j.get("id"));
		String ss = "";
		if(contractService.socketCheckRecoredBlock(info)) {
			ss = "exists";
		}else {
			ss = "none";
		}
		
		for(WebSocketSession s:webSocketSession) {
			if(s==session) {
				
				byte[] textBuffer = ss.getBytes();
				TextMessage text = new TextMessage(textBuffer);
				s.sendMessage(text);
			}
		}
		
	}
	
	
	
}
