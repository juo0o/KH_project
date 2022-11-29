package kh.study.intranet.address.vo;


import kh.study.intranet.emp.vo.EmpVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressVO {
	private String listPk;
	private String regUserId; //주소록에 등록한 사람
	private String empName;
	private String empTell;
	private String empAddr;
	private String empDetailAddr;
	private String empEmail;
	private String deptCode;
	private String deptName;
	private String empPosition;
	
//	private EmpVO empVO;
	
}
