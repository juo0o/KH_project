package kh.study.intranet.approval.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VacationVO {
	private String vacationSeq;
	private String vacationContent;
	private String vacationStartDate;
	private String vacationEndDate;
	private int vacationPeriodDate;
	private String userId;
	private String appSeq;
	
}