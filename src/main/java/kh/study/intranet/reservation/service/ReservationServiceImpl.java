package kh.study.intranet.reservation.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.reservation.vo.MeetingRoomVO;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MeetingRoomVO> selectMeetingRoom() {
		
		return sqlSession.selectList("reservationMapper.selectMeetingRoom");
	}

	@Override
	public void regReservation(MeetingRoomVO meetingRoomVO) {
		sqlSession.insert("reservationMapper.regReservation",meetingRoomVO);
		
	}

	
	
	
	
	
}
