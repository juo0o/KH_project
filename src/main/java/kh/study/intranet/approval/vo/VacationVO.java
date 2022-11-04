package kh.study.intranet.approval.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacationVO {
	private String vacationSeq;
	private String vacationAppSeq;
	private String vacationContent;
	private String vacationStatus;
	private String vacationPresent;
	private String vacationStratDate;
	private String vacationEndDate;
	private String deptCode;
	private String userId;
	private String appCateCode;
	ApprovalVO approvalVO;
}
