package kh.study.intranet.approval.service;

import java.util.List;
import java.util.Map;

import kh.study.intranet.approval.vo.AccountingVO;
import kh.study.intranet.approval.vo.AppCategoryVO;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.NomalVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.emp.vo.EmpVO;

public interface ApprovalService {
	
	ApprovalVO getAppSeq();
	
	
	EmpVO selectAppEmp(EmpVO empVO);
	
	void insertApproval(ApprovalVO approvalVO,VacationVO vacatioVO,NomalVO nomalVO
			, AccountingVO accountingVO);
	List<ApprovalVO> selectApp(Map<String, String> map);
	List<ApprovalVO> selectBoxList();
	
//	List<ApprovalVO> selectAppCateBoard(ApprovalVO approvalVO);
	
	
	
	

}
