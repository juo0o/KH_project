package kh.study.intranet.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.study.intranet.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	//게시글 목록 조회
	@Override
	public List<BoardVO> boardList(BoardVO boardVO) {
		return sqlSession.selectList("boardMapper.selectBoardList", boardVO);
	}

	//게시글 상세조회
	@Override
	@Transactional(rollbackFor = Exception.class)
	public BoardVO boardDetail(int boardNum) {
		
		sqlSession.update("boardMapper.updateReadCnt", boardNum);
				
		return sqlSession.selectOne("boardMapper.selectBoardDetail", boardNum);
	}
	
	//게시글 등록
	@Override
	public void regBoard(BoardVO boardVO) {
		sqlSession.insert("boardMapper.insertBoard", boardVO);
	}
	
	//게시글 수정
	@Override
	public void updateBoard(BoardVO boardVO) {
		sqlSession.update("boardMapper.updateBoard", boardVO);
	}
	
	//게시글 삭제
	@Override
	public void deleteBoard(BoardVO boardVO) {
		sqlSession.delete("boardMapper.deleteBoard", boardVO);
		
	}


}
	
//	//게시글 조회수 증가
//	@Override
//	public int updateReadCnt(int boardNum) {
//		return 1;
//	}
// 트랜잭션처리로 메소드 자체가 필요없음(쿼리문을 바로 serviceImpl로 가져다 쓰기때문)

	
	
	

