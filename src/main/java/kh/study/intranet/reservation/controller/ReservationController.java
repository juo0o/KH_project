package kh.study.intranet.reservation.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import kh.study.intranet.main.vo.UserVO;
import kh.study.intranet.reservation.service.ReservationService;
import kh.study.intranet.reservation.vo.MeetingRoomVO;
import kh.study.intranet.reservation.vo.ReservationVO;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Resource(name = "reservationService")
	private ReservationService reservationService;
	
	@RequestMapping("/insertReserve")
	public String insertReserve(MeetingRoomVO meetingRoomVO,Model model,ReservationVO reservationVO,Authentication authentication,UserVO userVO) {
		
		
		
		
		
		//User user = (User)authentication.getPrincipal();
		
		//reservationVO.setReserveUserId(user.getUsername());
		
		//reservationService.regReservation(meetingRoomVO);
		
		
		//model.addAttribute("reservation", reservationService.selectReservationInfo());
		//model.addAttribute("reserve", reservationService.selectReserve());
		
		
		model.addAttribute("meetingRoom", reservationService.selectMeetingRoom());
		
		//System.out.println(reservationService.selectMeetingRoom());
		//System.out.println(reservationService.selectMeetingRoom());
		
		return "pages/reservation/insertReserve";
	
	}
	
	
	@ResponseBody
	@PostMapping("/selectReserve")
	public List<ReservationVO> selectReserve(String reserveDate, Model model,String roomCode) {
		
		
		//System.out.println(reserveDate);
		
		
//		System.out.println("@@@@@@@@");
//		System.out.println(meetingRoomVO);
//		System.out.println(reservationVO);
//		System.out.println(reservationService.selectReservation(reserveDate));

		//System.out.println(reservationService.selectReservation(reserveDate));
		
		
		
		return reservationService.selectReservation(reserveDate);
		
		
	}
	
	
	//회의실 선택시 변경되는 ajax
	@ResponseBody
	@PostMapping("/selectChange")
	public List<ReservationVO> selectChange(ReservationVO reservationVO,Authentication authentication) {
//		System.out.println("!!!!!!!");
//		System.out.println(reservationVO);
//		System.out.println(reservationVO);
		
		
		
		List<ReservationVO> list = reservationService.selectAvailableReservation(reservationVO);
		
		//System.out.println(list);
		//User user = (User)authentication.getPrincipal();
		
		return list;
		
		
		
		
	}
	
	
	//등록 눌렀을때 실행되는 ajax
	@ResponseBody
	@PostMapping("/regReservation")
	public void regReservation(MeetingRoomVO meetingRoomVO,ReservationVO reservationVO,Authentication authentication) {
		
		//System.out.println("!!!!");
//		System.out.println(meetingRoomVO);
		//System.out.println(meetingRoomVO);
		//System.out.println(reservationVO);
		
		User user = (User)authentication.getPrincipal();
		
		reservationVO.setReserveUserId(user.getUsername());
		//reservationVO.setReserveDate();
		
		
		 //System.out.println("!!!!!!!!");
		 
		 //reservationService.regReservation(reservationVO);
		 reservationService.reserveUpdate(reservationVO); 
		
		 System.out.println(reservationVO);
		
		
	}
	
//	회의실 예약조회 눌렀을시
//	@GetMapping("/selectReserve")
//	public String selectReserve() {
//		
//		
//		return "";
//	}
	
	
}
