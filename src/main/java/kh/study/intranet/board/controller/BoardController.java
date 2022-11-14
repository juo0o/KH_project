package kh.study.intranet.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.study.intranet.board.service.BoardService;
import kh.study.intranet.board.service.BoardServiceImpl;
import kh.study.intranet.board.service.ReplyService;
import kh.study.intranet.board.vo.BoardVO;
import kh.study.intranet.board.vo.ReplyVO;
import kh.study.intranet.main.vo.UserVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "replyService")
	private ReplyService replyService;
	

	//게시글 목록 조회
	@GetMapping("/boardList")
	public String boardList(BoardVO boardVO, Model model) {
		List<BoardVO> list = boardService.boardList(boardVO);
		model.addAttribute("list",list);
		return "pages/board/board_list";
	}
	
	//상세 게시글 조회
	@GetMapping("/boardDetail")
	public String boardDetail(int boardNum, ReplyVO replyVO, Model model) {
		//게시글 상세 조회
		model.addAttribute("detail", boardService.boardDetail(boardNum));
		
		//댓글 조회
//		System.out.println(replyService.replyList(replyVO));
		model.addAttribute("reply", replyService.replyList(boardNum));
		return "pages/board/board_detail";
	}
	
	//댓글 작성
	@PostMapping("/regReply")
	public String regReply(ReplyVO replyVO) {
		replyService.regReply(replyVO);
		return"redirect:/board/boardDetail";
	}
	

	
//-------------------------------------	
	
	//게시글 등록 페이지로이동
	@GetMapping("/regBoardForm")
	public String regBoardForm(BoardVO boardVO) {
		return "pages/board/reg_Board";
	}
	
	//게시글 등록
	@PostMapping("/regBoard")
	public String regBoard(BoardVO boardVO, Authentication authentication) {
		
		//아이디 호출
		User user = (User)authentication.getPrincipal();
		boardVO.setUserId(user.getUsername());
		
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(user.getAuthorities());
//		
//		System.out.println("board :  " + boardVO);
		
		//게시글 등록메소드 실행
		boardService.regBoard(boardVO);
		return"redirect:/board/boardList";
	}
//--------------------------------
	
	//게시글 수정페이지로 이동
	@GetMapping("/updateBoardForm")
	public String updateBoardForm(int boardNum, Model model) {
		model.addAttribute("update", boardService.boardDetail(boardNum)); 
		return"pages/board/board_update";
	}
	
	//게시글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO boardVO, Model model) {
		boardService.updateBoard(boardVO);
		return"redirect:/board/boardDetail?boardNum=" + boardVO.getBoardNum() ;
	}
//------------------------------------
	
	//게시글 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO boardVO) {
		boardService.deleteBoard(boardVO);
		return"redirect:/board/boardList";
	}
	
//---------------------------------------
	

	
	
	
	
}








