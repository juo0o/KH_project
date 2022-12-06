package kh.study.intranet.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import kh.study.intranet.main.vo.UserVO;

@Service("sucessHandler")
public class LoginSucessHandler implements AuthenticationSuccessHandler   {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String url = "/main/mainPage";
		
		UserVO userVO = new UserVO();
		
		User user = (User)authentication.getPrincipal();
		userVO.setUserId(user.getUsername());
		
		userVO = sqlSession.selectOne("userMapper.selectUserInfo", userVO);
		
		//세션에넣고
		HttpSession session = request.getSession(true);
		
		session.setAttribute("userInfoAll", userVO);
		session.setMaxInactiveInterval(60*60*24);
		request.setAttribute("userInfoAll", session);
		//처음은 set
//		response.setHeader("Set-Cookie", "Test1=TestCookieValue1;   Secure; SameSite=None");
		
		//두번째는 add
		response.addHeader("Set-Cookie", "userInfoAll=userInfoAll;   Secure; SameSite=None");
//		response.addHeader("Set-Cookie", "Test2=TestCookieValue2;  Secure;  SameSite=None");
		
		
		request.setAttribute("userInfo", authentication);
		
		request.getSession().setMaxInactiveInterval(60*60*24);
		
		response.sendRedirect(url);
		
	}
}

