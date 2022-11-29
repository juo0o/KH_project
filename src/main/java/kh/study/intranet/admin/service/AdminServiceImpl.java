package kh.study.intranet.admin.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.study.intranet.admin.vo.RegEmpVO;
import kh.study.intranet.emp.vo.DeptVO;
import kh.study.intranet.main.vo.UserVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	
	//부서조회
	@Override
	public List<DeptVO> selectDeptList() {
		
		return sqlSession.selectList("adminMapper.selectDeptList");
	}
	
	//유저조회
	@Override
	public List<UserVO> selectEmpList() {
		
		return sqlSession.selectList("adminMapper.selectEmpList");
	}
	//유저조회 페이징 검색
	@Override
	public List<UserVO> selectEmpListSearchAndPage(Map<String, Object> map) {
		return sqlSession.selectList("adminMapper.selectEmpListSearchAndPage", map);
	}
	
	
	//관리자가 개인정보 업데이트
	public void updateEmpAdmin(Map<String, Object> update) {
		
		sqlSession.insert("adminMapper.updateEmpAdmin", update);
		
	}
	
	//신규사원 등록
	@Override
	public void regNewEmp(RegEmpVO regEmpVO) {
		sqlSession.insert("adminMapper.regNewEmp", regEmpVO);
		
	}
	
	//신규부서등록
	@Override
	public void regDept(DeptVO deptVO) {
		sqlSession.insert("adminMapper.regDept", deptVO);
	}



	

}
