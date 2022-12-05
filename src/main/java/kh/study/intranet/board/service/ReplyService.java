package kh.study.intranet.board.service;

import java.util.List;

import kh.study.intranet.board.vo.ReplyVO;

public interface ReplyService {
	
	//댓글 등록
	void regReply(ReplyVO replyVO);
	
	//댓글 조회
	List<ReplyVO> replyList(int boardNum);
	
	//댓글 수정
	void updateReply(ReplyVO replyVO);
	
	//댓글 삭제
	void deleteReply(ReplyVO replyVO);
}
