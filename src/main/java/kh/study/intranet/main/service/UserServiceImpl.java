package kh.study.intranet.main.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.study.intranet.main.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	@Autowired
	private PasswordEncoder encoder;
	
	//로그인
	@Override
	public UserVO loginProcess(String userName) {
		
		return sqlSession.selectOne("userMapper.loginUser", userName);
	}
	
	//회원가입
	@Override
	public void registerUser(UserVO userVO) {
		
		//비밀번호 암호화
		userVO.setUserPw(  encoder.encode(  userVO.getUserPw())  );
		
		
		sqlSession.insert("userMapper.joinMember", userVO);
		
	}

}
