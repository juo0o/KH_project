package kh.study.intranet.board.service;

import java.util.List;

import kh.study.intranet.board.vo.BoardVO;

public interface BoardService {
	
	//게시글 목록 조회
	List<BoardVO> boardList(BoardVO boardVO);
	
	//게시글 상세 조회
	BoardVO boardDetail(int boardNum);

}
