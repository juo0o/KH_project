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
	@GetMapping("/writeApproval")
	public String writeApproval(ApprovalVO approvalVO, Model model,Authentication authentication) {
		
		/*
		 * User user = (User)authentication.getPrincipal();
		 * commonFormVO.setUserId(user.getUsername());
		 */
		
		String appSeq = vacationApprovalService.getAppSeq();
		approvalVO.setAppSeq(appSeq);
		
		model.addAttribute("appSeq",approvalVO);
		 
		
		return "pages/approval/write_approval";
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
