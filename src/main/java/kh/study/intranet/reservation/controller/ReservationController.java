package kh.study.intranet.reservation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.study.intranet.reservation.service.ReservationService;
import kh.study.intranet.reservation.vo.MeetingRoomVO;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Resource(name = "reservationService")
	private ReservationService reservationService;
	
	@GetMapping("/insertReserve")
	public String insertReserve(MeetingRoomVO meetingRoomVO,Model model) {
		
		
		model.addAttribute("meetingRoom", reservationService.selectMeetingRoom());
		
		return "pages/reservation/insertReserve";
	
	}
}
