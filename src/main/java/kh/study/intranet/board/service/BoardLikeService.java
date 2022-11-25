package kh.study.intranet.board.service;

import kh.study.intranet.board.vo.BoardLikeVO;

public interface BoardLikeService {
	
	//좋아요 상태 확인
	BoardLikeVO boardLikeCheck(BoardLikeVO boardLikeVO);

	//좋아요 버튼 클릭
	void insertLike(BoardLikeVO boardLikeVO);
	
	
}
