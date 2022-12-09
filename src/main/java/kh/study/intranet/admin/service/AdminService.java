package kh.study.intranet.admin.service;

import java.util.List;
import java.util.Map;

import kh.study.intranet.admin.vo.RegEmpVO;
import kh.study.intranet.emp.vo.DeptVO;
import kh.study.intranet.main.vo.UserVO;

public interface AdminService {
	
	//부서조회
	List<DeptVO> selectDeptList();
	
	//유저조회
	List<UserVO> selectEmpList();
	
	//유저조회 검색,페이징
	List<UserVO> selectEmpListSearchAndPage(Map<String, Object> map);
	
	//관리자가 개인정보 업데이트
	void updateEmpAdmin( Map<String, Object> update);
	
	//신규사원 등록
	void regNewEmp(RegEmpVO regEmpVO);
	
	//신규부서등록
	void regDept(DeptVO deptVO);
}
