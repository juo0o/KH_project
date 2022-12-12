package kh.study.intranet.main.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO extends PageVO  {
	
		@NotBlank(message= "ID는 필수입력사항입니다.")
		private String userId;
		
		@NotBlank(message= "PW는 필수입력사항입니다.")
//		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$", message = "비밀번호는 최소8자 최대16자 영문 숫자 최소하나...")		
		@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "비밀번호는 최소 8 자, 최소 하나의 문자 및 하나의 숫자")		
		private String userPw;
		
		@NotBlank(message= "사번는 필수입력사항입니다.")
		private String empNum;
		
		@NotBlank(message= "이름은 필수입력사항입니다.")
		private String empName;
		

		private String empTell;
		private String empAddr;
		private String empDetailAddr;
		private String empEmail;
		private String deptCode ;
		private String deptName;
		private String empPosition;
		private String empRole;
		private String empPictureOriginName;
		private String empPictureRefileName;
		private String empHireDate;

	
	
	
	
	

}
