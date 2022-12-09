package kh.study.intranet.chat.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.chat.vo.ChatMessageVO;
import kh.study.intranet.chat.vo.ChatRoomVO;

@Service("chatService")
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	
    //채팅방 목록 조회
	@Override
	public List<ChatRoomVO> selectChatRoomList() {
		return sqlSession.selectList("chatMapper.selectChatRoom");
	}
    //메세지 입력
	@Override
	public void insertMessage(ChatMessageVO message) {
		sqlSession.insert("chatMapper.insertMessage", message);
	}
	//채팅방 메세지 조회
	@Override
	public List<ChatMessageVO> selectListChatMessage(String roomId) {
		return sqlSession.selectList("chatMapper.selectMessageList", roomId);
	}

}
