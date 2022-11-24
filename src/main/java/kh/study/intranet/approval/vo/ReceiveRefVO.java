package kh.study.intranet.approval.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReceiveRefVO {
	private String receiveRefNum;
	private String appSeq;
	private String firstApproval;
	private String firstApprovalEmp;
	private String finalApproval;
	private String finalApprovalEmp;
	private String appCateCode;
	private String appSeqStatus;
	private ApprovalVO approvalVO;
}
