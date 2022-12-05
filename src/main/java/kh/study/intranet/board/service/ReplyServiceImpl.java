package kh.study.intranet.board.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.board.vo.ReplyVO;



@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	//댓글 등록
	@Override
	public void regReply(ReplyVO replyVO) {
		sqlSession.insert("replyMapper.insertReply", replyVO);
		
	}

	//댓글 조회
	@Override 
	public List<ReplyVO> replyList(int boardNum) { 
	  return sqlSession.selectList("replyMapper.selectReply", boardNum); 
		  
	  }

	//댓글 수정
	@Override
	public void updateReply(ReplyVO replyVO) {
		sqlSession.update("replyMapper.updateReply", replyVO);
	}
	
	
	//댓글 삭제
	@Override
	public void deleteReply(ReplyVO replyVO) {
		sqlSession.delete("replyMapper.deleteReply", replyVO);
	}

	
	

	
	
	
}
