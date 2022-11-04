package kh.study.intranet.main.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.study.intranet.main.service.UserService;
import kh.study.intranet.main.vo.UserVO;


@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Resource(name="userService")
	UserService userService;

	//로그인화면으로간다
	@RequestMapping("/login")
	public String login() {
		
		return "/main/login_page";
	}
	
	//회원가입화면으로간다
	@RequestMapping("/register")
	public String register() {
		
		return "/main/register_page";
	}
		
	//회원가입
	@RequestMapping("/registerUser")
	public String registerUser(UserVO userVO) {
		
		userService.registerUser(userVO);
		
		
		
		return "redirect:/user/login";
	}
}
