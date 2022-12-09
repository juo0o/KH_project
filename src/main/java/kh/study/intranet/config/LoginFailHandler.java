package kh.study.intranet.config;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import kh.study.intranet.main.service.UserService;
import kh.study.intranet.main.vo.UserVO;

@Service("failHandler")
public class LoginFailHandler implements AuthenticationFailureHandler{

	
//	@Resource(name="userService")
//	UserService userService;
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String errormsg = null;
		
		
		//비밀번호, 아이디 모두 틀리면 발동, 비밀번호만 틀려도 발동
		//아이디가 틀리면 반드시 발동
		if(exception instanceof InternalAuthenticationServiceException) {
			errormsg = "아이디를 다시 입력해주세요.";
        }else if(exception instanceof BadCredentialsException) {
			errormsg = "비밀번호를 다시 입력해주세요.";
		}
		
		String url = "/user/login";
		
		request.setAttribute("errormsg", errormsg);
		
		//response.sendRedirect(url);
		RequestDispatcher dispatcherServlet = request.getRequestDispatcher(url);
		dispatcherServlet.forward(request, response);
	}

}
