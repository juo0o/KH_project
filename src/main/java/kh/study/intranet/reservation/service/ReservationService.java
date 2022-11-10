package kh.study.intranet.reservation.service;

import java.util.List;

import kh.study.intranet.reservation.vo.MeetingRoomVO;
import kh.study.intranet.reservation.vo.ReservationVO;

public interface ReservationService {
	
	List<MeetingRoomVO> selectMeetingRoom();
	
	void regReservation(MeetingRoomVO meetingRoomVO);
	
	List<ReservationVO> selectReservation(String reserveDate);
	
	void reserveUpdate(ReservationVO reservationVO);

}
