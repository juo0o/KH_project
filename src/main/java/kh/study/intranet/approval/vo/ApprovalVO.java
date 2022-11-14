package kh.study.intranet.approval.vo;

import kh.study.intranet.emp.vo.EmpVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovalVO  {
	private String appSeq;
	private String appWriteDate;
	private String firstTimeApprover;
	private String intermidiateApprover;
	private String finalApprover;
	private String appCheckStatus;
	private String userId;
	private EmpVO empVO;
	
}
