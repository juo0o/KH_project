package kh.study.intranet.approval.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Length;
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
import kh.study.intranet.approval.vo.AccountingVO;
import kh.study.intranet.approval.vo.AppCategoryVO;
import kh.study.intranet.approval.vo.ApprovalVO;
import kh.study.intranet.approval.vo.NomalVO;
import kh.study.intranet.approval.vo.ReceiveRefVO;
import kh.study.intranet.approval.vo.VacationVO;
import kh.study.intranet.config.appDateUtil;
import kh.study.intranet.emp.vo.EmpVO;
import kh.study.intranet.main.vo.PageVO;
import kh.study.intranet.main.vo.UserVO;

@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
	@Resource(name = "approvalService")
	private ApprovalService approvalService;
	
	@Resource(name="adminService")
	AdminService adminService;
	
	
	
	
	//결재리스트게시판
	@RequestMapping("/approvalBoard")
	public String approvalBoard(@RequestParam Map<String, Object> paramMap,Model model, ApprovalVO approvalVO,String appSeqStatus,PageVO pageVO) {
		
		Map<String, Object> countApp= new HashMap<>();
		countApp = approvalService.selectAppCount(appSeqStatus);
		
		
		model.addAttribute("countApp", countApp);
		
		
		model.addAttribute("appBoxList",approvalService.selectBoxList());
		
		
		
		
		
		//현재 날짜
		String nowDate = appDateUtil.getNowDateToString("-");//2020-10-10
		//한달 전날짜
		String beforeDate = appDateUtil.getBeforeMonthDateToString();
		
		//넘어오는 fromDate가 없다면 한달 전 날짜로 세팅
		if(paramMap.get("fromDate") == null) {
			paramMap.put("fromDate", beforeDate);
		}
		if(paramMap.get("toDate") == null){
			paramMap.put("toDate", nowDate);
		}
		
		//조건검색결과 데이터 수
				int totalDateCnt = approvalService.selectApp(paramMap).size();
				
				
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
				model.addAttribute("appList", approvalService.selectApp(paramMap));
				
				//페이징처리 vo보내줌
				model.addAttribute("pageVO", pageVO);
		
		
		return "pages/approval/approval_board";
	}
	
	
	
	
	
	
	//---------결재양식작성페이지----------------------------------------------------------------
	
	
	//휴가신청 작성페이지
	@GetMapping("/vacationReport")
	public String vacationReport(ApprovalVO approvalVO, Model model,Authentication authentication,EmpVO empVO,HttpSession session) {
		
		
		  User user = (User)authentication.getPrincipal();
		  empVO.setUserId(user.getUsername());
		  
		  UserVO emp = (UserVO)session.getAttribute("userInfoAll");
		  empVO.setDeptName(emp.getDeptName());
			
			
			
		  
		 model.addAttribute("empInfo", approvalService.selectAppEmp(empVO));
		 
		model.addAttribute("empRole", approvalService.selectRole(empVO));
		
		model.addAttribute("appSeq",approvalService.getAppSeq());
		
		
		 
		
		return "pages/approval/vacation_report";
	}
	//휴가신청서 등록
	@PostMapping("/regVacation")
	public String regVacation(VacationVO vacationVO,EmpVO empVO,ApprovalVO approvalVO,Authentication authentication,NomalVO nomalVO,AccountingVO accountingVO,ReceiveRefVO receiveRefVO) {
		
		User user = (User)authentication.getPrincipal();
		approvalVO.setUserId(user.getUsername());
		vacationVO.setUserId(user.getUsername());
		  
		
		  approvalService.insertApproval(approvalVO,vacationVO,nomalVO,accountingVO,receiveRefVO);
		
		//vacationApprovalService.insertVacation(vacationVO);
		
		
		return "redirect:/approval/vacationReport";
	}
	//일반품의서 작성페이지
	@GetMapping("/nomalReport")
	public String nomalReport (Model model,Authentication authentication,EmpVO empVO,HttpSession session) {
		
		User user = (User)authentication.getPrincipal();
		 empVO.setUserId(user.getUsername());
		 
		 UserVO emp = (UserVO)session.getAttribute("userInfoAll");
		 empVO.setDeptName(emp.getDeptName());
		 
		 model.addAttribute("empInfo", approvalService.selectAppEmp(empVO));
		 model.addAttribute("empRole", approvalService.selectRole(empVO));
		 model.addAttribute("appSeq",approvalService.getAppSeq());
		
		return "pages/approval/nomal_report";
	}
	//일반품의서 등록
	@PostMapping("/regNomal")
	public String regNomal(VacationVO vacationVO,EmpVO empVO,ApprovalVO approvalVO,NomalVO nomalVO,Authentication athenAuthentication,AccountingVO accountingVO,ReceiveRefVO receiveRefVO) {
		
		User user = (User)athenAuthentication.getPrincipal();
		approvalVO.setUserId(user.getUsername());
		nomalVO.setUserId(user.getUsername());
		
		 approvalService.insertApproval(approvalVO,vacationVO,nomalVO,accountingVO,receiveRefVO);
		
		return "redirect:/approval/nomalReport";
	}
	
	//회계품의서 작성페이지
	@GetMapping("/accountingReport")
	public String orderReport (EmpVO empVO,Authentication authentication, Model model,HttpSession session) {
		
		User user =(User)authentication.getPrincipal();
		empVO.setUserId(user.getUsername());
		
		//세션에서 부서명 뽑아내서 empVO에 넣기
		UserVO emp = (UserVO)session.getAttribute("userInfoAll");
		empVO.setDeptName(emp.getDeptName());
		
		model.addAttribute("empInfo", approvalService.selectAppEmp(empVO));
		model.addAttribute("empRole", approvalService.selectRole(empVO));
		model.addAttribute("appSeq", approvalService.getAppSeq());
		
		return "pages/approval/accounting_report";
	}
	//회계품의서 등록
	@PostMapping("/regAccounting")
	public String regAccounting(VacationVO vacationVO,EmpVO empVO,ApprovalVO approvalVO,NomalVO nomalVO,Authentication athenAuthentication,AccountingVO accountingVO,ReceiveRefVO receiveRefVO) {
		
		User user = (User)athenAuthentication.getPrincipal();
		approvalVO.setUserId(user.getUsername());
		accountingVO.setUserId(user.getUsername());
		
		approvalService.insertApproval(approvalVO,vacationVO,nomalVO,accountingVO,receiveRefVO);
		
		
		return "redirect:/approval/accountingReport";
	}
//--------------------------품의서별 승인페이지-------------------------------	
	// 결재 목록 승인페이지
	@GetMapping("/appDocuments")
	public String appDocuments(ApprovalVO approvalVO,Model model,VacationVO vacationVO,ReceiveRefVO receiveRefVO, Authentication authentication) {
		User user = (User)authentication.getPrincipal();
		approvalVO.setUserId(user.getUsername());
		
		System.out.println("시큐리티"+user.getUsername());
		
		Map<String, Object> ref= new HashMap<>();
		ref = approvalService.selectReciveRef(receiveRefVO);
		
		
		
		
		//휴가신청서 조회,승인페이지
		
		if(approvalVO.getAppCateCode().equals("VACATION")) {
			approvalVO.setTable("APP_FORM_VACATION");
			ApprovalVO document = approvalService.appDocuments(approvalVO);
			document.setAppWriteDate(document.getAppWriteDate().substring(0, 10));
			document.getVacationVO().setVacationStartDate(document.getVacationVO().getVacationStartDate().substring(0,10));
			document.getVacationVO().setVacationEndDate(document.getVacationVO().getVacationEndDate().substring(0,10));
			model.addAttribute("document", document);
			model.addAttribute("ref", ref);
			
			return "pages/approval/vacation_requestPage";
			
		//일반품의서 조회,승인페이지	
		}else if(approvalVO.getAppCateCode().equals("NOMAL")) {
			approvalVO.setTable("APP_FORM_NOMAL");
			ApprovalVO document = approvalService.appDocuments(approvalVO);
			document.setAppWriteDate(document.getAppWriteDate().substring(0, 10));
			model.addAttribute("document", document);
			model.addAttribute("ref", ref);
			
			return "pages/approval/nomal_requestPage";
			
		//회계품의서 조회,승인페이지	
		}else if(approvalVO.getAppCateCode().equals("ACCOUNTING")) {
			approvalVO.setTable("APP_FORM_ACCOUNTING");
			ApprovalVO document = approvalService.appDocuments(approvalVO);
			document.setAppWriteDate(document.getAppWriteDate().substring(0, 10));
			model.addAttribute("document", document);
			model.addAttribute("ref", ref);
			
			return "pages/approval/accounting_requestPage";
			
			
		}else {
			
			return "pages/main/mainPage";
		}
		
		
	}
	//승인권자만 확인할 수 있는 결재목록 페이지
	@GetMapping("/receiveAppPage")
	public String receiveAppPage(@RequestParam Map<String, Object> map,PageVO pageVO,Model model,HttpSession session,ApprovalVO approvalVO) {
		
		
	UserVO userVO= (UserVO)session.getAttribute("userInfoAll");
		
		//세션에서 뽑은 포지션 데이터 맵에 넣기
		map.put("empPosition", userVO.getEmpPosition());
		//세션에서 뽑은 사원번호 데이터 맵에 넣기
		map.put("empNum", userVO.getEmpNum());
		
	   
	   List<ApprovalVO> reciveList = approvalService.selectReceiveApp(map);
	   
		int totalDateCnt = reciveList.size();
		
	   //전체 데이터 수
	 	pageVO.setTotalDataCnt(totalDateCnt);
		//실행
		pageVO.setPageInfo();
		// 페이징에 따라 조회될 데이터를 넣어준다.
		map.put("startNum",pageVO.getStartNum());
		map.put("endNum", pageVO.getEndNum());
		

		model.addAttribute("reciveList",reciveList);

		for(ApprovalVO e : reciveList) {
			System.out.println(e);
		}
		
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("map", map);
		
		return "pages/approval/receive_App";
	}
//-------------------------------------------------------
	//결재승인버튼 클릭시 에이작스
	
	//첫번쨰 승인자가 결재승인 클릭시 도장찍힘
	@ResponseBody
	@PostMapping("/approvalMark")
	public void approvalMark(ReceiveRefVO receiveRefVO) {
		approvalService.updateApproval(receiveRefVO); 
		
	}
	//두번쨰 승인자가 결재승인 클릭시 도장찍힘
	@ResponseBody
	@PostMapping("/updateFinalApproval")
	public void approvalFinalMark(ReceiveRefVO receiveRefVO) {
		approvalService.updateFinalApproval(receiveRefVO); 
		
	}
	
	
	
	
		
	

	
	
}
