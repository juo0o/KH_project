package kh.study.intranet.reservation.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	@RequestMapping("/insertReserveAjax")
    @ResponseBody
    public Map<String, List<Object>> insertReserveAjX(){

       Map<String, List<Object>> dateList = new HashMap<>();
      
       //이용가능한 날짜
       dateList.put("avaDate", reservationService.availableDay());
       //이용 불가능한 날짜
       dateList.put("disDate", reservationService.disAvailableDay());
      
       return dateList;
    }
	
	//회의실 예약 등록화면으로 이동
	@RequestMapping("/insertReserve")
	public String insertReserve(UserVO userVO,Model model,Authentication authentication) {
		
		model.addAttribute("available", reservationService.availableReserve());
		
		//회의실 조회
		model.addAttribute("meetingRoom", reservationService.selectMeetingRoom());
		
		//내 예약 조회
		User user = (User)authentication.getPrincipal();
		userVO.setUserId(user.getUsername());
		model.addAttribute("selectMyReserve", reservationService.selectMyReserve(userVO));
		
		
		return "pages/reservation/insertReserve";
	
	}
		
	//내 예약 취소 
	@ResponseBody
	@RequestMapping("/deleteReserve")
	public void deleteReserve(ReservationVO reservationVO) {
		
	
		reservationService.deleteReserve(reservationVO);
	}
	
	@ResponseBody
	@PostMapping("/selectReserve")
	public List<ReservationVO> selectReserve(String reserveDate, Model model,String roomCode) {
		
		return reservationService.selectReservation(reserveDate);
	}
	
	
	//회의실 선택시 변경되는 ajax
	@ResponseBody
	@PostMapping("/selectChange")
	public List<ReservationVO> selectChange(ReservationVO reservationVO,Authentication authentication) {
		List<ReservationVO> list = reservationService.selectAvailableReservation(reservationVO);
		
		return list;
		
	}
	
	
	//회의실 등록 눌렀을때 실행되는 ajax
	@ResponseBody
	@PostMapping("/regReservation")
	public ReservationVO regReservation(UserVO userVO,MeetingRoomVO meetingRoomVO,ReservationVO reservationVO,Authentication authentication) throws ParseException {
		
		User user = (User)authentication.getPrincipal();
		userVO.setUserId(user.getUsername());
		reservationVO.setReserveUserId(user.getUsername());
		
		if(reservationVO.getReserveName() == null || reservationVO.getReserveName() == "") {
			reservationVO.setReserveName("");
		}
		
		if(reservationVO.getReserveComment() == null || reservationVO.getReserveComment() == "") {
			reservationVO.setReserveComment("");
		}
		
		//등록쿼리
		reservationService.reserveUpdate(reservationVO); 
		
		//내 예약 조회해서 마지막꺼찾는다.
		ReservationVO recentRegRes = new ReservationVO();
		
		for(ReservationVO e : reservationService.selectMyReserve(userVO)) {
			if(e.getReserveTime().equals(reservationVO.getReserveTime()) && e.getReserveDate().equals(reservationVO.getReserveDate()) ) {
				recentRegRes = e;
			}
		}
		// 결과 리턴
		return recentRegRes;
	}
	
	//회의실 예약조회 눌렀을시 페이지 이동
	@GetMapping("/selectReserve")
	public String selectReserve() {
		
		return "pages/reservation/selectReserve";
	}
	
	//회의실 예약현황 조회하고 ajax
	@ResponseBody
	@RequestMapping("/selectAjax")
	public Map<String, List<ReservationVO>> selectAjax() {
		
		Map<String, List<ReservationVO>> listMap = new HashMap<>();
		
	
        List<ReservationVO> reservedList = new ArrayList<>();
        reservedList = reservationService.selectReserveAll();
		
        String[] date;
		for(ReservationVO e : reservedList ){
			
			date = e.getReserveTime().split("-");
			e.setStartTime(date[0]);
			e.setEndTime(date[1]);
			
		}
		
		listMap.put("reservedList", reservedList);
		
		return listMap;
		
	}
	
	//회의실 예약날짜 자동등록 반복문
	@RequestMapping("/insertReserveTime")
	public void insertAllSchedules(String time ,MeetingRoomVO meetingRoom){
		
//		month = 12;
//		day = 31;
//		time = "09:00 - 12:00";
		String[] timeArray = {"09:00-12:00","12:00-15:00","15:00-18:00"};
		
		System.out.println(timeArray[0]);
		System.out.println(timeArray[1]);
		System.out.println(timeArray[2]);
		
		for(int k = 0; k < timeArray.length; k++) {
			meetingRoom.setTime(timeArray[k]);
			for(int j = 1; j < 4; j++) {
				meetingRoom.setRoomCode("ROOM_00" + j);
				
				for(int i = 1; i < 32; i++) {
					meetingRoom.setDay("2022-12-" + i);
					reservationService.insertReserveTime(meetingRoom);
				}
				
			}
			
		}
		
	
		
	}
	
	
	
	
}
