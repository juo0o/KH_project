package kh.study.intranet.approval.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vacationApprovalService")
public class VacationApprovalServiceImpl implements VacationApprovalService{

	@Autowired
	private SqlSessionTemplate sqlSession;
		
	
}
