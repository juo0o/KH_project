package kh.study.intranet.config;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import kh.study.intranet.main.service.UserService;
import kh.study.intranet.main.vo.UserVO;

@Service("failHandler")
public class LoginFailHandler implements AuthenticationFailureHandler{

	
//	@Resource(name="userService")
//	UserService userService;
	
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String url = "/user/login";
		
		
		System.out.println("로그인실패시 여기로온다!!!!!!!!!!!");
		
		
		response.sendRedirect(url);
	}

}
