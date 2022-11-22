package kh.study.intranet.admin.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.study.intranet.admin.service.AdminService;
import kh.study.intranet.approval.service.ApprovalService;
import kh.study.intranet.approval.service.NomalApprovalService;
import kh.study.intranet.approval.service.VacationApprovalService;
import kh.study.intranet.approval.vo.AccountingVO;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.NomalVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.emp.vo.EmpVO;
import kh.study.intranet.main.service.UserService;
import kh.study.intranet.main.vo.UserVO;

@Controller
@RequestMapping("/admin")
public class AdminlController {
	
	@Resource(name = "adminService")
	AdminService adminService;
	
	@Resource(name="userService")
	UserService userService;
	
	//직원조회
	@RequestMapping("/selectEmpList")
	public String selectEmpList(Model model) {
		
		model.addAttribute("empList",adminService.selectEmpList());
		
		return "/pages/admin/selectEmpList";
	}
	
	
	//사원정보 수정 페이지
	@RequestMapping("/adminUpdateUserForm")
	public String updateUserForm(UserVO userVO, Model model) {
		
		model.addAttribute("userInfo", userService.selectUserInfo(userVO));
		
		return "/main/update_user_page";
	}
	//사원정보수정
	
	@RequestMapping("/adminUpdateUser")
	public String adminUpdateUser(UserVO userVO, Model model) {
		
		System.out.println(userVO);
		System.out.println(userVO);
		System.out.println(userVO);
		System.out.println(userVO);
		System.out.println("~~~~~~~~~~~~~~ ");
		System.out.println("~~~~~~~~~~~~~~ ");
		System.out.println("~~~~~~~~~~~~~~ ");
		System.out.println("~~~~~~~~~~~~~~ ");
		System.out.println("~~~~~~~~~~~~~~ ");
		System.out.println("~~~~~~~~~~~~~~ ");
		
		return "redirect:/admin/adminUpdateUserForm?userId=" + userVO.getUserId();
	}
	
	//직원등록
	
	//부서등록
	
	//부서조회 
	
	
	
}
