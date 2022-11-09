package kh.study.intranet.reservation.service;

import java.util.List;

import kh.study.intranet.reservation.vo.MeetingRoomVO;

public interface ReservationService {
	
	List<MeetingRoomVO> selectMeetingRoom();
	
	void regReservation(MeetingRoomVO meetingRoomVO);

}
