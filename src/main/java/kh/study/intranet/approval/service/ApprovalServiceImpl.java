package kh.study.intranet.approval.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.study.intranet.alarm.vo.AlarmVO;
import kh.study.intranet.approval.vo.AccountingVO;
import kh.study.intranet.approval.vo.AppCategoryVO;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.NomalVO;
import kh.study.intranet.approval.vo.ReceiveRefVO;
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
	
	@Override
	public List<EmpVO> selectRole(EmpVO empVO) {
		return sqlSession.selectList("approvalMapper.selectRole",empVO);
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void insertApproval(ApprovalVO approvalVO,VacationVO vacationVO,NomalVO nomalVO,AccountingVO accountingVO,ReceiveRefVO receiveRefVO,AlarmVO alarmVO ) {
		sqlSession.insert("approvalMapper.insertApproval",approvalVO);
		
		System.out.println(vacationVO);
		System.out.println(vacationVO);
		System.out.println("  ");
		System.out.println(nomalVO);
		System.out.println(nomalVO);
		System.out.println("  ");
		System.out.println(accountingVO);
		System.out.println(accountingVO);
		System.out.println();
		System.out.println(receiveRefVO);
		System.out.println(receiveRefVO);
		
		if(vacationVO.getUserId() != null) {
			
			sqlSession.insert("approvalMapper.insertVacation",vacationVO);
		} else if(nomalVO.getUserId() != null) {
			
			sqlSession.insert("approvalMapper.insertNomal",nomalVO);
		} else {
			sqlSession.insert("approvalMapper.insertAccounting",accountingVO);
			
		}
		
		sqlSession.insert("approvalMapper.insertReceiveRef",receiveRefVO);
		sqlSession.insert("alarmMapper.insertAlarm",alarmVO);
	}


	@Override
	public List<ApprovalVO> selectApp(Map<String, Object> map) {
		return sqlSession.selectList("approvalMapper.selectApp",map);
	}


	@Override
	public List<ApprovalVO> selectBoxList() {
		return sqlSession.selectList("approvalMapper.selectBoxList");
	}


	@Override
	public ApprovalVO appDocuments(ApprovalVO approvalVO) {
		return sqlSession.selectOne("approvalMapper.appDocuments",approvalVO);
	}


	@Override
	public HashMap<String, Object> selectReciveRef(ReceiveRefVO receiveRefVO) {
		return sqlSession.selectOne("approvalMapper.selectReciveRef",receiveRefVO);
	}

	@Override
	public void updateApproval(ReceiveRefVO receiveRefVO) {
		sqlSession.update("approvalMapper.updateApproval",receiveRefVO);
		
		
	}


	@Override
	public void updateFinalApproval(ReceiveRefVO receiveRefVO) {
		sqlSession.update("approvalMapper.updateFinalApproval",receiveRefVO);
	}


	@Override
	public HashMap<String, Object> selectAppCount(String appSeqStatus) {
		return sqlSession.selectOne("approvalMapper.selectAppCount",appSeqStatus);
	}


	@Override
	public List<ApprovalVO> selectReceiveApp(Map<String, Object> map) {
		return sqlSession.selectList("approvalMapper.selectReceiveApp",map);
	}

}
