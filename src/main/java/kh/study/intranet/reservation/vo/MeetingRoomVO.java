package kh.study.intranet.reservation.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MeetingRoomVO {
	private String roomCode;
	private String roomName;
	private String available;
	
	private String time;
	private String day;
	
	
	
}
