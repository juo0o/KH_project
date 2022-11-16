package kh.study.intranet.main.service;

import java.util.Map;

import kh.study.intranet.main.vo.UserVO;

public interface UserService {
	//login
	UserVO loginProcess(String userName);
	
	
	//회원가입
	void registerUser(UserVO userVO);
	
    //유저정보조회
	UserVO selectUserInfo(UserVO userVO);
	
	//유저정보 업데이트
	void updateUserInfo(Map<String, String> variableMap);
	
	//사진등록
	void regEmpPicture(UserVO userVO);
}
