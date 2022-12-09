package kh.study.intranet.chat.controller;

import javax.annotation.Resource;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.study.intranet.chat.service.ChatService;
import kh.study.intranet.chat.vo.ChatMessageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/chat")
public class ChatController {
	
	
	private SimpMessagingTemplate template;
	
	@Resource(name="chatService")
	ChatService chatService;
	
	
	//채팅페이지로 이동하고 채팅방 목록 보여줌
	@GetMapping("/chatForm")
	public String chat(Model model) {
		
		log.info("# All Chat Rooms");
		
		return "/pages/chat/chatting";
	}
	
	//채팅방 목록페이지로 이동
	@GetMapping("/chat_room_list")
	public String chat_loom_list(Model model, String roomId,String roomName) {
		
		//채팅방리스트 보내줌
		model.addAttribute("list", chatService.selectChatRoomList());
		
		model.addAttribute("roomId", roomId);
		model.addAttribute("roomName", roomName);
		
		return "/pages/chat/chat_room_list";
	}
	//채팅방 조회
	@GetMapping("/chat_room")
	public String getRoom(String roomId,String roomName, Model model){
		
	    log.info("# get Chat Room, roomID : " + roomId);
	    
	    //채팅방 목록조회
	    model.addAttribute("list", chatService.selectChatRoomList());
	    
	    
	    model.addAttribute("roomId", roomId);
	    model.addAttribute("roomName", roomName);
	    
	    //채팅메세지 보내주기
	    if(roomId !=null) {
	    	model.addAttribute("messageList", chatService.selectListChatMessage(roomId));
	    }
	    
	    return "/pages/chat/chat_room";
	}
	
	//채팅방 조회2
		@GetMapping("/chat_room2")
		public String getRoom2(String roomId,String roomName, Model model){
		
		    log.info("# get Chat Room, roomID : " + roomId);
		    
		    //채팅방 목록조회
		    model.addAttribute("list", chatService.selectChatRoomList());
		
//		    model.addAttribute("room", repository.findRoomById(roomId));
		    model.addAttribute("roomId", roomId);
		    model.addAttribute("roomName", roomName);
		    
		    //채팅메세지 보내주기
		    if(roomId !=null) {
		    	model.addAttribute("messageList", chatService.selectListChatMessage(roomId));
		    }
		    
		    return "/pages/chat/chat_room2";
		}
	

}
