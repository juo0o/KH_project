package kh.study.intranet.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.study.intranet.board.service.BoardService;
import kh.study.intranet.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	//게시글 목록 조회
	@GetMapping("/boardList")
	public String boardList(BoardVO boardVO, Model model) {
		model.addAttribute("boardList", boardService.boardList(boardVO));
		return "pages/board/board_list";
	}
	
	//상세 게시글 조회
	@GetMapping("/boardDetail")
	public String boardDetail(int boardNum, Model model) {
		BoardVO board = boardService.boardDetail(boardNum);
		model.addAttribute("boardDetail", board);
		return "pages/board/board_detail";
	}
	
	//게시글 등록 페이지로이동
	@GetMapping("/regBoardForm")
	public String regBoardForm(BoardVO boardVO) {
		return "pages/board/reg_Board";
	}
	
	
	
	//게시글 등록
	@PostMapping("/regBoard")
	public String regBoard(BoardVO boardVO) {
		
		//아이디 호출
		
		//게시글 등록메소드 실행
		boardService.regBoard(boardVO);
		return"pages/board/board_list";
	}
	
	
	
}








