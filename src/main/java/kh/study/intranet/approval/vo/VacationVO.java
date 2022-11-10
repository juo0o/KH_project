package kh.study.intranet.approval.vo;

import kh.study.intranet.emp.vo.DeptVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
	DeptVO deptVO;
}