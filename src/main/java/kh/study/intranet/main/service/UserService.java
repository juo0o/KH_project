package kh.study.intranet.main.service;

import kh.study.intranet.main.vo.UserVO;

public interface UserService {
	//login
	UserVO loginProcess(String userName);
	
	
	//회원가입
	void registerUser(UserVO userVO);
}
