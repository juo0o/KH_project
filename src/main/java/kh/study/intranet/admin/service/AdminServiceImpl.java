package kh.study.intranet.admin.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.study.intranet.main.vo.UserVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<UserVO> selectEmpList() {
		
		return sqlSession.selectList("adminMapper.selectEmpList");
	}

	public void updateEmpAdmin(Map<String, Object> update) {
		
		sqlSession.insert("adminMapper.updateEmpAdmin", update);
		
	}
	
	

}
