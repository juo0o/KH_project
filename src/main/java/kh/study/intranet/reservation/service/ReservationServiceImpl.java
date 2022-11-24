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

	@Override
	public List<ReservationVO> selectReserveAll() {
		
		return sqlSession.selectList("reservationMapper.selectReserveAll");
	}

	@Override
	public List<ReservationVO> availableReserve() {
		
		return sqlSession.selectList("reservationMapper.availableReserve");
	}

	//예약가능날자
   @Override
   public List<Object> availableDay() {
      return sqlSession.selectList("reservationMapper.availableDay");
   }
   //예약 불가능 날짜 조회
   @Override
   public List<Object> disAvailableDay() {
      
      return sqlSession.selectList("reservationMapper.disAvailableDay");
   }



	

	
	
	
	
	
}
