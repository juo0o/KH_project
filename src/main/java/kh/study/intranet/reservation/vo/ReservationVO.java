package kh.study.intranet.reservation.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ReservationVO  {
	private String reserveCode;
	private String reserveUserId;
	private String roomCode;
	private String reserveDate;
	private String reserveTime;
	private String reserveAvailable;
	
	
		
}
