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


//시큐리티 셋팅법
//
//1. SecurityConfig 클래스 config패키지에 작성
//2. /login , /loginFail 맵핑들 컨트롤러에 작성
//3. member-mapper , MemberServiceImpl , UserDetailsServiceImpl 작성





@Configuration // @Configuration : 해당 클래스가 설정파일임을 스프링에게 인지
@EnableWebSecurity // @EnableWebSecurity : 해당 클래스로부터 만들어진 객체가 security 설정 파일임을 인지
public class SecurityConfig {
	
//	
//	@Resource(name="sucessHandler")
//	AuthenticationSuccessHandler sucessHandler;
//	
//	@Resource(name="failHandler")
//	AuthenticationFailureHandler failHandler;
	
	

	//매개변수로 들어온  HttpSecurity security 객체를 사용해서  인증 및 인가에 대한 제어를 구성한다.
	@Bean // 메소드의 리턴 타입에 대한 객체를 생성, 메소드 위에서 정의한다
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		//security 사용, csrf 공격을 막기위한 기본 설정을 해제한다.
		security.csrf().disable();
		
		security
				.authorizeRequests() // authorizeRequests() : 권한(인증,인가 모두 지칭) 에 대한 설정을 시작
					.antMatchers("/main/**"
								).permitAll() // antMatchers("/~~") : ~~ 요청에 대한 설정을 하겠다.  permitAll "~~"요청에 대한 접근은 누구나 접근가능 
//					.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//					.antMatcher("/cart/**).
//				.and()
//				.formLogin()
//					.loginPage("/login") //spring 로그인 페이지가 아닌 커스터마이징한 로그인 페이지로 이동하겠다.
//					.successHandler(sucessHandler)
					//failhandler추가해준다\
//					.failureHandler(failHandler)
//					.defaultSuccessUrl("/member/loginResult?isSuccess=true")
//		            .failureUrl("/member/loginResult?isSuccess=false")	//나중에 추가해볼까
//					.usernameParameter("memberId")
//					.passwordParameter("memberPw")
				
//				.and()
//				.logout()
//					.logoutUrl("/member/logout")
//					.invalidateHttpSession(true)
//					.logoutSuccessUrl("/item/list")
				
				//.and()						나중에 추가해볼까
				//.exceptionHandling().accessDeniedPage("/accessDenied"); 권한없을때
				;
		
		return security.build();
	}
	
	//암호화 기능을 갖는 객체를 하나 생성!
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//관리자권한 핸들러
	
}
	
//	인증 및 인가 테스트ㅡㄹ 위한 계정 생성 메소드
//	@Bean
//	public InMemoryUserDetailsManager userDetailService() {
//		List<UserDetails> userList = new ArrayList<>();
//		
//		userList.add(	User.withUsername("admin")
//							.password("{noop}admin")
//							.roles("MANAGER")
//							.build()	);
//		
//		userList.add(	User.withUsername("1")
//							.password("{noop}1")
//							.roles("ADMIN", "MANAGER")
//							.build()	);
//		
//		return new InMemoryUserDetailsManager(userList);
//	}