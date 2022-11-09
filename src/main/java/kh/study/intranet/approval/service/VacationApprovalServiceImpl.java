package kh.study.intranet.approval.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.CommonFormVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.emp.vo.EmpVO;

@Service("vacationApprovalService")
public class VacationApprovalServiceImpl implements VacationApprovalService{

	@Autowired
	private SqlSessionTemplate sqlSession;


	@Override
	public ApprovalVO getAppSeq() {
		return sqlSession.selectOne("approvalMapper.getAppSeq");
	}


	@Override
	public EmpVO selectAppEmp(EmpVO empVO) {
		return sqlSession.selectOne("approvalMapper.selectAppEmp",empVO);
	}
	
	
		
	
}
