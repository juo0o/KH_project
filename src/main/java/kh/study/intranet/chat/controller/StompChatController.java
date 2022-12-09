package kh.study.intranet.chat.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import kh.study.intranet.chat.service.ChatService;
import kh.study.intranet.chat.vo.ChatMessageVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StompChatController {

	@Autowired
	private SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
	
	@Resource(name="chatService")
	ChatService chatService;
	
	
	//client 가 send 할 수 있는 경로
	//stompConfig에서 설정한 applicationDestinationPrefixed 와 @massage mapping 경로가 병합된다
	//"/publish/chat/enter"
	@MessageMapping(value="/chat/enter")
	public void enter(ChatMessageVO message) {
		message.setMessage(message.getUserId() + "님이 채팅방에 참여하였습니다");
		template.convertAndSend("subscribe/chat/enter/" + message.getRoomId(), message);
	}

	@MessageMapping(value = "/chat/message")
	public void message(ChatMessageVO message) {
		
//		메세지 입력 db에 저장
		chatService.insertMessage(message);
		
		template.convertAndSend("/subscribe/chat/room/" + message.getRoomId(), message);
	}

}
