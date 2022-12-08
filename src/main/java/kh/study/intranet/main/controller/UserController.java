package kh.study.intranet.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.study.intranet.config.uploadFileUtil;
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
	public String login(HttpSession session) {
			
			UserVO vo = (UserVO)session.getAttribute("userInfoAll");
			System.out.println("!!!!" + vo);
			
		return "/main/login_page";
	}
	
	//회원가입화면으로간다
	@RequestMapping("/register")
	public String register(UserVO userVO) {
		
		return "/main/register_page";
	}
	
	
	//아이디 중복확인
	@ResponseBody
	@RequestMapping("/confirmId")
	public boolean confirmId(UserVO userVO) {
		UserVO userInfo = 	userService.selectUserInfo(userVO);
		
		System.out.println("!!!!!!!!!!!!!!!!!컨트롤러 옴?????");
		
		System.out.println("user~~~~ :  "+ userInfo);
		if(userInfo == null) {
			System.out.println("null");
			return true;
		}
		else {
			System.out.println("not null");
			return false;
		}
	}
	
	
	// @Valid : post로 전달된 데이터가 검증 규칙을 따르는지 확인
	// @BindingResult : 검증대상 객체와 검증 결과에 대한 정보를 담고 있는 객체
	//					검증 객체 바로 다음 순서에 선언되어야 한다......
	// Valid 쓸거면 사실상 두개는 묶여있다!?
	//회원가입
	@PostMapping("/registerUser")
	public String registerUser(@Valid UserVO userVO, BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			System.out.println("error");
			return "/main/register_page";
		}
		userService.registerUser(userVO);
		
		
		
		return "redirect:/user/login";
	}
	
	
	//내정보 조회
	
    //내정보 수정 페이지로 이동
	
	@RequestMapping("/updateUserForm")
	public String updateUserForm(UserVO userVO, Model model, Authentication authentication) {
		
		User user = (User)authentication.getPrincipal();
		userVO.setUserId(user.getUsername());
		
		
		model.addAttribute("userInfo", userService.selectUserInfo(userVO));
		
		return "/main/update_user_page";
	}
	
	
	//내정보 수정
	@PostMapping("/updateUserInfo")
	@ResponseBody
	public UserVO updateUserInfo(UserVO userVO, String keyVariable,String valueVariable,Authentication authentication) {
		
		Map<String, String> variableMap = new HashMap<>();  
		
		variableMap.put("keyVariable", keyVariable);
		
		User user = (User)authentication.getPrincipal();
		userVO.setUserId(user.getUsername());
		variableMap.put("userId", user.getUsername());
		
		
//		나중에 사용
		if(keyVariable.equals("USER_PW")) {
			variableMap.put("valueVariable", encoder.encode(valueVariable));
		}else {
			variableMap.put("valueVariable", valueVariable);
		}
		//업데이트 쿼리 실행
		userService.updateUserInfo(variableMap);
		
		return userService.selectUserInfo(userVO);
		
	}
	
	// 사진등록
	@PostMapping("/regPicture")
	@ResponseBody
	public UserVO regPicture( MultipartFile empPictureOriginName, Authentication authentication) {
		
		UserVO userVO = uploadFileUtil.uploadFile(empPictureOriginName);
		
		User user = (User)authentication.getPrincipal();
		userVO.setUserId(user.getUsername());
		
		System.out.println("@@@@@@@@@" + userVO);
		System.out.println("@@@@@@@@@" + userVO);
		System.out.println("@@@@@@@@@" + userVO);
		
		userService.regEmpPicture(userVO);
		
		return userVO;
	}
	
}
