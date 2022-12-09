package kh.study.intranet.main.service;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.study.intranet.main.vo.UserVO;

@Service("userDetailsService")
@ResponseBody
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserVO userVO = sqlSession.selectOne("userMapper.loginMember", username);
		
		// UserDetails 의 리턴값이 없을때 발생하는예외
		if(userVO == null) {
			throw new InternalAuthenticationServiceException("아이디를 찾을수 없습니다.");
		}
		
		//조회되지않으면 던짐, BadCredentialException 로받음
//		if(userVO == null) {
//			throw new UsernameNotFoundException("아이디를 찾을수 없습니다.");
//		}
		
		
		UserDetails userDetail = User.withUsername(userVO.getUserId())
									 .password(userVO.getUserPw())
									 .roles(userVO.getEmpRole())
									 .build();
		
		return userDetail;
	}
}
