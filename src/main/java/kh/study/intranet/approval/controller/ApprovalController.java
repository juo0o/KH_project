package kh.study.intranet.approval.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.study.intranet.approval.service.ApprovalService;
import kh.study.intranet.approval.service.VacationApprovalService;

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
	
	//결재양식작성페이지
	@GetMapping("/writeApproval")
	public String writeApproval() {
		
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
