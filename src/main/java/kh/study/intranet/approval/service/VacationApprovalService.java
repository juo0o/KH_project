package kh.study.intranet.approval.service;

import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.CommonFormVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.emp.vo.EmpVO;

public interface VacationApprovalService {
	
	ApprovalVO getAppSeq();
	
	EmpVO selectAppEmp(EmpVO empVO);
	
	
	

}
