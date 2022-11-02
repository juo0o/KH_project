package kh.study.intranet.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
