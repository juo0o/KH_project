package kh.study.intranet.admin.service;

import java.util.List;
import java.util.Map;

import kh.study.intranet.main.vo.UserVO;

public interface AdminService {
	
	List<UserVO> selectEmpList();
	
	void updateEmpAdmin( Map<String, Object> update);
}
