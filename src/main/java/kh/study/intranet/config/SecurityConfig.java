package kh.study.intranet.config;


import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



@Configuration 
@EnableWebSecurity 
public class SecurityConfig {
	
	
	@Resource(name="sucessHandler")
	AuthenticationSuccessHandler sucessHandler;
	@Resource(name="failHandler")
	AuthenticationFailureHandler failHandler;
	
	

	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		//security 사용, csrf 공격을 막기위한 기본 설정을 해제한다.
		security.csrf().disable();
		
		security
				.authorizeRequests() // authorizeRequests() : 권한(인증,인가 모두 지칭) 에 대한 설정을 시작
					.antMatchers("/user/login", "/user/register").permitAll() // antMatchers("/~~") : ~~ 요청에 대한 설정을 하겠다.  permitAll "~~"요청에 대한 접근은 누구나 접근가능 
					.antMatchers("/main/**",
							     "/adress/**",
							     "/chat/**",
							     "/approval/**",
							     "/board/**",
							     "/reservation/**").authenticated()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().permitAll()
				.and()
				.formLogin()
					.loginPage("/user/login") //spring 로그인 페이지가 아닌 커스터마이징한 로그인 페이지로 이동하겠다.
					.loginProcessingUrl("/user/login_start") //로그인 Form Action Url, default: /login
					.usernameParameter("userId")
					.passwordParameter("userPw")
					//successHandler
					.successHandler(sucessHandler)
					//failhandler추가해준다\
					.failureHandler(failHandler)
//					.defaultSuccessUrl("/member/loginResult?isSuccess=true")
				.and()
				.logout()
					.logoutUrl("/user/logout")
					.invalidateHttpSession(true)
					.logoutSuccessUrl("/user/login")
				.and()					//	나중에 추가해볼까
				.exceptionHandling().accessDeniedPage("/main/accessDenied"); // 권한없을때
				;
		
		return security.build();
	}
	
	//암호화 기능을 갖는 객체를 하나 생성!
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}
