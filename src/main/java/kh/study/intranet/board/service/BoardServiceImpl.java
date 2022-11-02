package kh.study.intranet.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public BoardVO boardDetail(int boardNum) {
		return sqlSession.selectOne("boardMapper.selectBoardDetail", boardNum);
	}
	
	
}
