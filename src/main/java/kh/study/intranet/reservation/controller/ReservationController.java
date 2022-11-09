package kh.study.intranet.reservation.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/insertReserve")
	public String insertReserve(MeetingRoomVO meetingRoomVO,Model model,ReservationVO reservationVO,Authentication authentication,UserVO userVO) {
		
		
		//User user = (User)authentication.getPrincipal();
		
		//reservationVO.setReserveUserId(user.getUsername());
		
		//reservationService.regReservation(meetingRoomVO);
		

		model.addAttribute("meetingRoom", reservationService.selectMeetingRoom());
		
		return "pages/reservation/insertReserve";
	
	}
	
	@ResponseBody
	@PostMapping("/regReservation")
	public void regReservation(MeetingRoomVO meetingRoomVO,ReservationVO reservationVO) {
		
		reservationService.regReservation(meetingRoomVO);
		
	}
	
	
}
