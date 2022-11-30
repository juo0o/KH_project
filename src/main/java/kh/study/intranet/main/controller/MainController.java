package kh.study.intranet.main.controller;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kh.study.intranet.board.vo.BoardVO;
import kh.study.intranet.main.service.MainService;
import kh.study.intranet.main.service.UserService;
import kh.study.intranet.main.vo.UserVO;

@Controller
@RequestMapping("/main")
@SessionAttributes("userInfo") //얘로하면 클래스네에서 ModelMap으로 세션에저장된거 바로받아올수있음
public class MainController {
	
	
	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="mainService")
	MainService mainService;
	
	@RequestMapping("/mainPage")
	public String mainPage(UserVO userVO,Authentication authentication, Model model) {
		
		
		User user = (User)authentication.getPrincipal();
		userVO.setUserId(user.getUsername());
		
		//유저정보 보내줌
		model.addAttribute("userInfo", userService.selectUserInfo(userVO));
		
		//최근5개 게시글 보여줌
		model.addAttribute("recentBoard", mainService.selectRecentBoard());
		
		
		return "/main/mainPage";
	}
	
	@RequestMapping("/index")
	public String indexPage() {
		
		return "/main/index";
	}
	
	
	
	

}
