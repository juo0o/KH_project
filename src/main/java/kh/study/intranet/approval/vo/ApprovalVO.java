package kh.study.intranet.approval.vo;

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
	private String appCheckDate;
	private String appReson;
	private String appOriginFilename;
	private String appRefileFilename;
	private String appWriterEmpNum;
	private String appCheckProgress;
	private String appCateCode;
}
