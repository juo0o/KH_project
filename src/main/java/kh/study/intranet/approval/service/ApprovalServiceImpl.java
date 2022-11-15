package kh.study.intranet.approval.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.study.intranet.approval.vo.AccountingVO;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.NomalVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.emp.vo.EmpVO;

@Service("approvalService")
public class ApprovalServiceImpl implements ApprovalService{

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
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void insertApproval(ApprovalVO approvalVO,VacationVO vacationVO,NomalVO nomalVO,AccountingVO accountingVO) {
		sqlSession.insert("approvalMapper.insertApproval",approvalVO);
		
		System.out.println(vacationVO);
		System.out.println(vacationVO);
		System.out.println("  ");
		System.out.println(nomalVO);
		System.out.println(nomalVO);
		System.out.println("  ");
		System.out.println(accountingVO);
		System.out.println(accountingVO);
		
		if(vacationVO.getUserId() != null) {
			
			sqlSession.insert("approvalMapper.insertVacation",vacationVO);
		} else if(nomalVO.getUserId() != null) {
			
			sqlSession.insert("approvalMapper.insertNomal",nomalVO);
		} else {
			sqlSession.insert("approvalMapper.insertAccounting",accountingVO);
			
		}
	}


	@Override
	public List<ApprovalVO> selectApp(ApprovalVO approvalVO) {
		return sqlSession.selectList("approvalMapper.selectApp",approvalVO);
	}


	@Override
	public List<ApprovalVO> selectBoxList() {
		return sqlSession.selectList("approvalMapper.selectBoxList");
	}


	@Override
	public List<ApprovalVO> selectAppCateBoard(ApprovalVO approvalVO) {
		return sqlSession.selectList("approvalMapper.selectAppCateBoard",approvalVO);
	}

	
}
