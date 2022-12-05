package kh.study.intranet.main.service;

import java.util.List;

import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.board.vo.BoardVO;
import kh.study.intranet.main.vo.UserVO;

public interface MainService {
	

	//최근5개 게시글 조회
	List<BoardVO> selectRecentBoard();
	
	//공지사항 조회
	List<BoardVO> noticeBoard();
	
	//결재해야할 문서 조회
	List<ApprovalVO> documentsToBeApproved(UserVO userVO);
	
}
