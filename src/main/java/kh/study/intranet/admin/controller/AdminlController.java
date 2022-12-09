package kh.study.intranet.admin.controller;

import java.util.HashMap;
import java.util.Map;

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

import groovyjarjarantlr4.v4.parse.ANTLRParser.delegateGrammar_return;
import kh.study.intranet.admin.service.AdminService;
import kh.study.intranet.admin.vo.RegEmpVO;
import kh.study.intranet.approval.service.ApprovalService;
import kh.study.intranet.approval.service.NomalApprovalService;
import kh.study.intranet.approval.service.VacationApprovalService;
import kh.study.intranet.approval.vo.AccountingVO;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.NomalVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.config.appDateUtil;
import kh.study.intranet.emp.vo.DeptVO;
import kh.study.intranet.emp.vo.EmpVO;
import kh.study.intranet.main.service.UserService;
import kh.study.intranet.main.vo.PageVO;
import kh.study.intranet.main.vo.UserVO;

@Controller
@RequestMapping("/admin")
public class AdminlController {
	
	@Resource(name="adminService")
	AdminService adminService;
	
	@Resource(name="userService")
	UserService userService;
	
	//검색기능 + 페이징처리 합침
	@RequestMapping("/selectEmpList")
	public String selectEmpList(@RequestParam Map<String, Object> paramMap,PageVO pageVO,Model model) {
		
		//부서정보 보내줌
		model.addAttribute("deptList", adminService.selectDeptList());
		
		
		//map에 날짜 세팅
		// 현재 날짜
		String nowDate = appDateUtil.getNowDateToString("-");// 2020-10-10
		// 한달 전날짜
		String beforeDate = appDateUtil.getBeforeMonthDateToString();
		
//		 넘어오는 fromDate가 없다면 한달 전 날짜로 세팅
//		if (paramMap.get("fromDate") == null) {
//			paramMap.put("fromDate", beforeDate);
//		}
//		if (paramMap.get("toDate") == null) {
//			paramMap.put("toDate", nowDate);
//		}
		 
		//조건검색결과 데이터 수
		int totalDateCnt = adminService.selectEmpListSearchAndPage(paramMap).size();
		
		
		//검색결과 전체데이터 수 넣어준다.
		pageVO.setTotalDataCnt(totalDateCnt);
		//실행
		pageVO.setPageInfo();
		
		// 페이징에 따라 조회될 데이터를 넣어준다.

		paramMap.put("startNum",pageVO.getStartNum());
		paramMap.put("endNum", pageVO.getEndNum());
		
		//map 보내줌
		model.addAttribute("paramMap", paramMap);
		//검색결과 보내줌
		model.addAttribute("empList", adminService.selectEmpListSearchAndPage(paramMap));
		
		//페이징처리 vo보내줌
		model.addAttribute("pageVO", pageVO);
		
		return "/pages/admin/selectEmpList";
	}
	
	
	//사원정보 수정 페이지
	@RequestMapping("/adminUpdateUserForm")
	public String updateUserForm(UserVO userVO, Model model) {
		
		model.addAttribute("userInfo", userService.selectUserInfo(userVO));
		
		return "/main/update_user_page";
	}
	
	//사원정보수정
	@ResponseBody
	@RequestMapping("/adminUpdateUser")
	public UserVO adminUpdateUser(UserVO userVO ,String adminUpdateKey,String adminModalSelect , Model model) {
		
		Map<String, Object> update = new HashMap<>();
		
		update.put("COLUMN", adminUpdateKey);
		update.put("VALUE", adminModalSelect);
		update.put("USER_ID", userVO.getUserId());
		
		adminService.updateEmpAdmin(update);
		
		return userService.selectUserInfo(userVO);
	}
	
	//사원등록 Ajax
	@ResponseBody
	@RequestMapping("/regNewEmp")
	public String regNewEmp(RegEmpVO regEmpVO) {
		adminService.regNewEmp(regEmpVO);
		return "aaa";
	}
	
	//부서등록 Ajax
	@ResponseBody
	@RequestMapping("/regDept")
	public String regDept(DeptVO deptVO) {
		adminService.regDept(deptVO);
		return "aaa";
	}
	
	
}
