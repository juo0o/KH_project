package kh.study.intranet.board.service;

import java.util.List;
import java.util.Map;

import kh.study.intranet.board.vo.BoardCategoryVO;
import kh.study.intranet.board.vo.BoardVO;

public interface BoardService {

	//게시판 최신 공지사항 상단 3개
	List<BoardVO> selectNoticeBoardList(Map<String, Object> map);
	
	//게시판 추천글 상단 3개
	List<BoardVO> selectLikeBoardList (Map<String, Object> map);
	
	//게시글 검색 및 목록 조회 
	List<BoardVO> selectBoardListAndSearch(Map<String, Object> map);
	
	//게시판 카테고리 조회
	List<BoardVO> selectBoardCate();
	
	
	//게시글 상세 조회
	BoardVO boardDetail(int boardNum);
	
	//게시글 등록
	void regBoard(BoardVO boardVO);
	
	//게시글 수정
	void updateBoard(BoardVO boardVO);
	
	//게시글 삭제
	void deleteBoard(BoardVO boardVO);
	
//	//게시글 조회수 증가
//	List<BoardVO> updateReadCnt( BoardVO boardVO, int boardNum);
// 트랜잭션처리로 메소드 자체가 필요없음(쿼리문을 바로 serviceImpl로 가져다 쓰기때문)
	
	
	
	//게시글 총 개수 조회
	int selectBoardCnt();
	
	
}
