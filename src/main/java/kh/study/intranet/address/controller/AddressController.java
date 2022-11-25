package kh.study.intranet.address.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.study.intranet.address.service.AddressService;
import kh.study.intranet.address.vo.AddressListVO;
import kh.study.intranet.address.vo.AddressVO;
import kh.study.intranet.emp.vo.EmpVO;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Resource(name = "addressService")
	private AddressService addressService;
	
	@GetMapping("/addressList")
	public String addressList(AddressVO addressVO,Model model,Authentication authentication,EmpVO empVO,AddressListVO addressListVO) {
		
		User user =(User)authentication.getPrincipal();
		addressListVO.setBookOwnerId(user.getUsername());
		
		
		model.addAttribute("myAddressList", addressService.insertAddressList(addressListVO.getBookOwnerId()));
		
		//System.out.println(addressService.insertAddressList(bookOwnerId));
		
		model.addAttribute("addressList", addressService.addressList());
		
		
		return "pages/address/addressList";
	}
	
	@ResponseBody
	@PostMapping("/insertAddress")
	public List<AddressListVO> insertAddress(AddressListVO addressListVO,AddressVO addressVO,Authentication authentication) {
		
		User user = (User)authentication.getPrincipal();
		addressListVO.setBookOwnerId(user.getUsername());
		
		addressService.insertAddress(addressListVO);
		
		addressService.insertAddressList(addressListVO.getBookOwnerId());
		
		
		return 	addressService.insertAddressList(addressListVO.getBookOwnerId());

	}
	@GetMapping("/myAddress")
	public String myAddress() {
		
		return "";
	}
	
	
	
}
