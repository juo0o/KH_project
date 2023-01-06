package kh.study.intranet.approval.vo;

import kh.study.intranet.alarm.vo.AlarmVO;
import kh.study.intranet.emp.vo.EmpVO;
import kh.study.intranet.main.vo.UserVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApprovalVO  {
	private String appSeq;
	private String appWriteDate;
	private String title;
	private String appCateCode;
	private String userId;
	private EmpVO empVO;
	private VacationVO vacationVO;
	private NomalVO nomalVO;
	private AccountingVO accountingVO;
	private AppCategoryVO appCategoryVO;
	private ReceiveRefVO receiveRefVO;
	private UserVO userVO;
	private AlarmVO alarmVO;
	
	
	private String table;
	
	
}
