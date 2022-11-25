package kh.study.intranet.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.board.vo.BoardLikeVO;

@Service("boardLikeService")
public class BoardLikeServiceImpl implements BoardLikeService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	//좋아요 상태 확인
	@Override
	public BoardLikeVO boardLikeCheck(BoardLikeVO boardLikeVO) {
		return sqlSession.selectOne("boardLikeMapper.boardLikeCheck", boardLikeVO);
	}

	//좋아요 버튼 클릭
	public void insertLike(BoardLikeVO boardLikeVO) {
		sqlSession.insert("boardLikeMapper.insertLike", boardLikeVO);
	}



	
	

	
	
	
}
