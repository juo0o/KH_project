package kh.study.intranet.reservation.service;

import java.util.List;

import kh.study.intranet.reservation.vo.MeetingRoomVO;
import kh.study.intranet.reservation.vo.ReservationVO;

public interface ReservationService {
	
	//회의실 조회
	List<MeetingRoomVO> selectMeetingRoom();
	
	void regReservation(MeetingRoomVO meetingRoomVO);
	
	//날짜정보
	List<ReservationVO> selectReservation(String reserveDate);
	
	
	void reserveUpdate(ReservationVO reservationVO);
	
	//사용 가능 회의실
	List<ReservationVO> selectAvailableReservation(ReservationVO reservationVO);
	
	
	
	
	
	
}
