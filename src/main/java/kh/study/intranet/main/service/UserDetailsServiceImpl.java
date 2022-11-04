package kh.study.intranet.main.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		if(userVO == null) {
			throw new UsernameNotFoundException("아이디를 찾을수 없습니다.");
		}
		
		System.out.println(userVO);
		System.out.println(userVO);
		System.out.println(userVO);
		System.out.println(userVO);
		System.out.println(userVO);
		
		UserDetails userDetail = User.withUsername(userVO.getUserId())
									 .password(userVO.getUserPw())
									 .roles(userVO.getEmpRole())
									 .build();
		
		
		
		
		return userDetail;
	}
}
