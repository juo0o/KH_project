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
		
		
		
		
		String url = "/user/login";
		
		request.setAttribute("errormsg", errormsg);
		
		//response.sendRedirect(url);
		RequestDispatcher dispatcherServlet = request.getRequestDispatcher(url);
		dispatcherServlet.forward(request, response);
	}

}
