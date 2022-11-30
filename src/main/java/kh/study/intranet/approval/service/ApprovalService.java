package kh.study.intranet.approval.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.study.intranet.approval.vo.AccountingVO;
import kh.study.intranet.approval.vo.AppCategoryVO;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.NomalVO;
import kh.study.intranet.approval.vo.ReceiveRefVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.emp.vo.EmpVO;

public interface ApprovalService {
	
	ApprovalVO getAppSeq();
	
	
	EmpVO selectAppEmp(EmpVO empVO);
	
	List<EmpVO> selectRole();
	
	void insertApproval(ApprovalVO approvalVO,VacationVO vacatioVO,NomalVO nomalVO
			, AccountingVO accountingVO, ReceiveRefVO receiveRefVO);
	List<ApprovalVO> selectApp(Map<String, Object> map);
	List<ApprovalVO> selectBoxList();
	
//	List<ApprovalVO> selectAppCateBoard(ApprovalVO approvalVO);
	
	ApprovalVO appDocuments(ApprovalVO approvalVO);
	
	HashMap<String, Object> selectReciveRef(ReceiveRefVO receiveRefVO);
	
	void updateApproval(ReceiveRefVO receiveRefVO);
	void updateFinalApproval(ReceiveRefVO receiveRefVO);
	
	HashMap<String, Object> selectAppCount(String appSeqStatus);
}
