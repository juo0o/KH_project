package kh.study.intranet.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service("sucessHandler")
public class LoginSucessHandler implements AuthenticationSuccessHandler   {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String url = "/main/mainPage";
		
//		switch (authentication.getAuthorities().toString()) {
//		case "[ROLE_ADMIN]":
//			url = "/admin/regItem";
//		break;
//		}
		
		
		request.getSession().setMaxInactiveInterval(60*60*24);
		
		request.setAttribute("userInfo", authentication);
		
		response.sendRedirect(url);
		
	}
}

