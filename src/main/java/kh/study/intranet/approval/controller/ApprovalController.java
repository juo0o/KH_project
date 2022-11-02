package kh.study.intranet.approval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
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
}
