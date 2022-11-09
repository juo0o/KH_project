package kh.study.intranet.chat.service;

import java.util.List;

import kh.study.intranet.chat.vo.ChatMessageVO;
import kh.study.intranet.chat.vo.ChatRoomVO;

public interface ChatService {
	//채팅방 목록 조회
	List<ChatRoomVO> selectChatRoomList();
	
	//메세지 db저장
	void insertMessage(ChatMessageVO message);
	
	//채팅방 메세지 조회
	List<ChatMessageVO> selectListChatMessage(String roomId);
}
