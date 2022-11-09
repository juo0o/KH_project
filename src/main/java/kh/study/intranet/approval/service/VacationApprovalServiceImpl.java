package kh.study.intranet.approval.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.CommonFormVO;
import kh.study.intranet.approval.vo.VacationVO;

@Service("vacationApprovalService")
public class VacationApprovalServiceImpl implements VacationApprovalService{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public VacationVO selectVacationReport(VacationVO vacationVO) {
		return sqlSession.selectOne("approvalMapper.selectVacationReport",vacationVO);
	}

	@Override
	public CommonFormVO selectCommonForm(CommonFormVO commonFormVO) {
		
		
		return sqlSession.selectOne("approvalMapper.selectCommonForm",commonFormVO);
	}

	@Override
	public String getAppSeq() {
		return sqlSession.selectOne("approvalMapper.getAppSeq");
	}
	
	
		
	
}
