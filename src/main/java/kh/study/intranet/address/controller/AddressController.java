package kh.study.intranet.address.controller;

import java.util.List;
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

import kh.study.intranet.address.service.AddressService;
import kh.study.intranet.address.vo.AddressListVO;
import kh.study.intranet.address.vo.AddressVO;
import kh.study.intranet.admin.service.AdminService;
import kh.study.intranet.config.appDateUtil;
import kh.study.intranet.emp.vo.EmpVO;
import kh.study.intranet.main.vo.PageVO;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Resource(name = "addressService")
	private AddressService addressService;
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@RequestMapping("/addressList")
	public String addressList(@RequestParam Map<String, Object> paramMap,AddressVO addressVO,Model model,Authentication authentication,EmpVO empVO,AddressListVO addressListVO,PageVO pageVO) {
		
			//부서정보 보내줌
			model.addAttribute("deptList", adminService.selectDeptList());
			
			
			//map에 날짜 세팅
			// 현재 날짜
			String nowDate = appDateUtil.getNowDateToString("-");// 2020-10-10
			// 한달 전날짜
			String beforeDate = appDateUtil.getBeforeMonthDateToString();
			 //넘어오는 fromDate가 없다면 한달 전 날짜로 세팅
				
//			if (paramMap.get("fromDate") == null) {
//					
//				paramMap.put("fromDate", beforeDate);
//				
//				}
//				
//			if (paramMap.get("toDate") == null) {
//				
//				paramMap.put("toDate", nowDate);
//			
//				}
			 
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
			model.addAttribute("addressList", adminService.selectEmpListSearchAndPage(paramMap));
			
			//페이징처리 vo보내줌
			model.addAttribute("pageVO", pageVO);
		
		
		
	
			User user =(User)authentication.getPrincipal();
			addressListVO.setBookOwnerId(user.getUsername());
			
			//다음에 들어갈 List_pk 값 조회
			//String listPk = addressService.selectNextListPk();
			model.addAttribute("myAddressList", addressService.insertAddressList(addressListVO.getBookOwnerId()));
			
		
		return "pages/address/addressList";
	}
	
	@ResponseBody
	@PostMapping("/insertAddress")
	public List<AddressListVO> insertAddress(AddressListVO addressListVO,AddressVO addressVO,Authentication authentication,Model model) {
		
		
		User user = (User)authentication.getPrincipal();
		addressListVO.setBookOwnerId(user.getUsername());
		addressListVO.setBookName(addressListVO.getBookName());
		
		addressService.insertAddress(addressListVO);
		
		//addressService.insertAddressList(addressListVO.getBookOwnerId());
		
		
		return 	addressService.insertAddressList(addressListVO.getBookOwnerId());

	}
	@GetMapping("/myAddress")
	public String myAddress(String listPk, Model model,String bookPk) {
		
	
		
		model.addAttribute("myAddressList", addressService.selectListPk(listPk));
		
		model.addAttribute("listPk", listPk);
		
		
		return "pages/address/myAddressList";
	}
	
	//연락처 추가 클릭시
	@GetMapping("/addAddress")
	public String addAddress(String listPk,Model model) {

		model.addAttribute("listPk", listPk);
		
		return "pages/address/insertAddress";
	}
	//연락처 등록
	@PostMapping("/regAddress")
	public String regAddress(String listPk,AddressVO addressVO,Model model) {
		
		addressService.regMyAddress(addressVO);
		
		return "redirect:/address/myAddress?listPk=" + listPk;
	}
	//주소록 수정페이지로 이동
	@GetMapping("/updateAddress")
	public String updateAddress(Model model,String bookPk,String listPk) {
		
		model.addAttribute("book", addressService.selectBookPk(bookPk));
		
		return "pages/address/updateAddress";
		
	}
	//개인주소록 수정
	@PostMapping("/updateAddressForm")
	public String updateAddressForm(AddressVO addressVO,Model model) {
		
		
		addressService.updateAddress(addressVO);
		
		return "redirect:/address/myAddress?listPk=" + addressVO.getListPk();
	}
	
	//삭제 버튼 ajax
	@ResponseBody
	@PostMapping("/deleteAddress")
	public void deleteBtn(AddressVO addressVO) {
		
		addressService.deleteAddress(addressVO);
		
	}
	
	
	
}
