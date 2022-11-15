package kh.study.intranet.reservation.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.reservation.vo.MeetingRoomVO;
import kh.study.intranet.reservation.vo.ReservationVO;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MeetingRoomVO> selectMeetingRoom() {
		
		return sqlSession.selectList("reservationMapper.selectMeetingRoom");
	}

	@Override
	public void regReservation(ReservationVO reservationVO) {
		sqlSession.insert("reservationMapper.regReservation",reservationVO);
		
	}

	@Override
	public List<ReservationVO> selectReservation(String reserveDate) {
		
		return sqlSession.selectList("reservationMapper.selectReservation", reserveDate);
	}

	@Override
	public void reserveUpdate(ReservationVO reservationVO) {
		sqlSession.update("reservationMapper.reserveUpdate",reservationVO);
		
	}

	@Override
	public List<ReservationVO> selectAvailableReservation(ReservationVO reservationVO) {
		
		return sqlSession.selectList("reservationMapper.selectAvailableReservation",reservationVO);
	}

	



	

	
	
	
	
	
}
