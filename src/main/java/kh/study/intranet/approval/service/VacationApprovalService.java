package kh.study.intranet.approval.service;

import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.CommonFormVO;
import kh.study.intranet.approval.vo.VacationVO;

public interface VacationApprovalService {
	
	VacationVO selectVacationReport(VacationVO vacationVO);
		
	CommonFormVO selectCommonForm(CommonFormVO commonFormVO);
	
	String getAppSeq();
	
	

}
