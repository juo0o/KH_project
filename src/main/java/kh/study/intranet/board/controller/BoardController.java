package kh.study.intranet.board.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.study.intranet.board.service.BoardLikeService;
import kh.study.intranet.board.service.BoardService;
import kh.study.intranet.board.service.ReplyService;
import kh.study.intranet.board.vo.BoardLikeVO;
import kh.study.intranet.board.vo.BoardVO;
import kh.study.intranet.board.vo.ReplyVO;
import kh.study.intranet.config.appDateUtil;
import kh.study.intranet.main.vo.PageVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;

	@Resource(name = "replyService")
	private ReplyService replyService;

	@Resource(name = "boardLikeService")
	private BoardLikeService boardLikeService;

	
	
	// 게시글 목록 조회
	@RequestMapping("/boardList")
	public String boardList(@RequestParam Map<String, Object> paramMap, PageVO pageVO, Model model, Authentication authentication) {

		
		System.out.println("!!!!!!!" + paramMap.get("orderBy"));
		
		if(paramMap.get("orderBy") == null || paramMap.get("orderBy") =="") {
			paramMap.put("orderBy", "BOARD_NUM");
		}

		//id확인
//		User user = (User)authentication.getPrincipal();
//		boardVO.setUserId(user.getUsername());
		
		//map에 날짜 세팅
		// 현재 날짜
		String nowDate = appDateUtil.getNowDateToString("-");// 2020-10-10
		// 한달 전날짜
		String beforeDate = appDateUtil.getBeforeMonthDateToString();
		// 넘어오는 fromDate가 없다면 한달 전 날짜로 세팅
		if (paramMap.get("fromDate") == null) {
			paramMap.put("fromDate", beforeDate);
		}
		if (paramMap.get("toDate") == null) {
			paramMap.put("toDate", nowDate);
		}
		 
		//조건검색결과 데이터 수
		int totalDateCnt = boardService.selectBoardListAndSearch(paramMap).size();
		
		
		
		//검색결과 전체데이터 수 넣어준다.
		pageVO.setTotalDataCnt(totalDateCnt);
		//실행
		pageVO.setPageInfo();
		
		System.out.println(pageVO);
		System.out.println(pageVO);
		System.out.println(pageVO);
		
		
		// 페이징에 따라 조회될 데이터를 넣어준다.
		paramMap.put("startNum",pageVO.getStartNum());
		paramMap.put("endNum", pageVO.getEndNum());
		
		//map 보내줌
		model.addAttribute("paramMap", paramMap);
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!cateCode = " + paramMap.get("boardCateCode"));
		
		//게시판 카테고리조회
		model.addAttribute("boardCate", boardService.selectBoardCate());

		//검색결과 보내줌
		model.addAttribute("boardList", boardService.selectBoardListAndSearch(paramMap));
		
		//추천글 3개정렬
		model.addAttribute("likeBoardList", boardService.selectLikeBoardList(paramMap));
		
		//최신 공지사항 3개 정렬
		model.addAttribute("noticeBoardList", boardService.selectNoticeBoardList(paramMap));
		
		//페이징처리 vo보내줌
		model.addAttribute("pageVO", pageVO);
		
		
		

		return "pages/board/board_list";
	}
	
	

	
	
	// 상세 게시글 조회
	@GetMapping("/boardDetail")
	public String boardDetail(int boardNum,String aaa, ReplyVO replyVO, BoardLikeVO boardLikeVO, Authentication authentication , Model model) {
	    
		// 게시글 상세 조회
		model.addAttribute("detail", boardService.boardDetail(boardNum));

		// 댓글 조회
		model.addAttribute("reply", replyService.replyList(boardNum));
		
		
		//좋아요 상태 확인
		User user = (User)authentication.getPrincipal();
		boardLikeVO.setUserId(user.getUsername());
		
		BoardLikeVO result = boardLikeService.boardLikeCheck(boardLikeVO);

		boolean isLike;
		
		//좋아요가 눌리지 않은 상태
		if(result == null) {
			model.addAttribute("like", false);
		}
		else{
		//좋아요를 누른상태
			model.addAttribute("like", true);
		}
		
		
		return "pages/board/board_detail";
		
	}
	
	//게시글 좋아요 기능
	@ResponseBody
	@PostMapping("/insertLike")
	public boolean insertLike(BoardLikeVO boardLikeVO, Model model, Authentication authentication) {
		//id확인
		User user = (User)authentication.getPrincipal();
		boardLikeVO.setUserId(user.getUsername());
		
		
		boardLikeService.insertLike(boardLikeVO);
		
		//좋아요 상태 확인
		BoardLikeVO isLike = boardLikeService.boardLikeCheck(boardLikeVO);

		boolean result;
		
		//좋아요가 눌리지 않은 상태
		if(isLike == null) {
			result = false;
		}
		else{
		//좋아요를 누른상태
			result = true;
		}
		
		return result;
	}
	

	// 댓글 등록
	@PostMapping("/regReply")
	public String regReply(ReplyVO replyVO, Authentication authentication) {
		// userId
		User user = (User) authentication.getPrincipal();
		replyVO.setUserId(user.getUsername());

		replyService.regReply(replyVO);
		return "redirect:/board/boardDetail?boardNum=" + replyVO.getBoardNum();
	}
	
	//댓글 수정
	@PostMapping("/updateReply")
	public String updateReply(ReplyVO replyVO) {
		
		
		replyService.updateReply(replyVO);
		return	"redirect:/board/boardDetail?boardNum=" + replyVO.getBoardNum();
	}
	
	
	// 댓글 삭제
	@GetMapping("/deleteReply")
	public String deleteReply(ReplyVO replyVO) {
		replyService.deleteReply(replyVO);
		return "redirect:/board/boardDetail?boardNum=" + replyVO.getBoardNum();
	}



//-------------------------------------	

	// 게시글 등록 페이지로이동
	@GetMapping("/regBoardForm")
	public String regBoardForm(BoardVO boardVO, Model model) {
		//boardcategory 테이블에서 카테고리 싹다 조회해
		//리스트 model로 html로 보내서
		// select박스 그려준다. 이름은 cateName value= catecode  

		model.addAttribute("boardCate", boardService.selectBoardCate()); 
		
		return "pages/board/reg_Board";
	}

	// 게시글 등록
	@PostMapping("/regBoard")
	public String regBoard(BoardVO boardVO, Authentication authentication) {

		// 아이디 호출
		User user = (User) authentication.getPrincipal();
		boardVO.setUserId(user.getUsername());

	
		// 게시글 등록메소드 실행
		boardService.regBoard(boardVO);
		
		
		return "redirect:/board/boardList";
	}
//--------------------------------

	// 게시글 수정페이지로 이동
	@GetMapping("/updateBoardForm")
	public String updateBoardForm(int boardNum, Model model) {
		model.addAttribute("update", boardService.boardDetail(boardNum));
		return "pages/board/board_update";
	}

	// 게시글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO boardVO, Model model) {
		boardService.updateBoard(boardVO);
		return "redirect:/board/boardDetail?boardNum=" + boardVO.getBoardNum();
	}

	// 게시글 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO boardVO) {
		boardService.deleteBoard(boardVO);
		return "redirect:/board/boardList";
	}

//---------------------------------------

}
