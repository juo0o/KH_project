package kh.study.intranet.main.service;

import java.util.List;

import kh.study.intranet.board.vo.BoardVO;
import kh.study.intranet.main.vo.UserVO;

public interface MainService {
	

	//최근5개 게시글 조회
	List<BoardVO> selectRecentBoard();
}
