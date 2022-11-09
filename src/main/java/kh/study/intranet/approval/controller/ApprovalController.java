package kh.study.intranet.approval.controller;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kh.study.intranet.approval.service.ApprovalService;
import kh.study.intranet.approval.service.VacationApprovalService;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.CommonFormVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.emp.vo.DeptVO;
import kh.study.intranet.emp.vo.EmpVO;

@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
	@Resource(name = "approvalService")
	private ApprovalService approvalService;
	
	@Resource(name = "vacationApprovalService")
	private VacationApprovalService vacationApprovalService;
	
	
	//결재리스트게시판
	@GetMapping("/approvalBoard")
	public String approvalBoard() {
		
		
		
		return "pages/approval/approval_board";
	}
	
	//---------결재양식작성페이지----------------------
	
	
	//휴가신청 작성페이지
	@GetMapping("/vacationReport")
	public String vacationReport(ApprovalVO approvalVO, Model model,Authentication authentication,EmpVO empVO) {
		
		
		  User user = (User)authentication.getPrincipal();
		  empVO.setUserId(user.getUsername());
		
		 model.addAttribute("empInfo", vacationApprovalService.selectAppEmp(empVO));
		 
		
		/*
		 * String appSeq = vacationApprovalService.getAppSeq();
		 * approvalVO.setAppSeq(appSeq);
		 */
		
		
		model.addAttribute("appSeq",vacationApprovalService.getAppSeq());
		
		/*
		 * String nowDate = ShopDateUtil.getNowDateToString("-");//2020-10-10 //한달 전날짜
		 * String beforeDate = ShopDateUtil.getBeforeMonthDateToString();
		 * 
		 * //넘어오는 fromDate가 없다면 한달 전 날짜로 세팅 if(paramMap.get("fromDate") == null) {
		 * paramMap.put("fromDate", beforeDate); } if(paramMap.get("toDate") == null){
		 * paramMap.put("toDate", nowDate); }
		 */
		
		//model.addAttribute("paramMap", paramMap);
		
		 
		
		return "pages/approval/vacation_report";
	}
	@GetMapping("/nomalReport")
	public String nomalReport () {
		
		return "pages/approval/nomal_report";
	}
	@GetMapping("/orderReport")
	public String orderReport () {
		
		return "pages/approval/order_report";
	}
}
