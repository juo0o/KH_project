package kh.study.intranet.address.controller;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.study.intranet.address.service.AddressService;
import kh.study.intranet.address.vo.AddressVO;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Resource(name = "addressService")
	private AddressService addressService;
	
	@GetMapping("/addressList")
	public String addressList(AddressVO addressVO,Model model,Authentication authentication) {
		
		User user =(User)authentication.getPrincipal();
		
		
		model.addAttribute("addressList", addressService.addressList());
		
		return "pages/address/addressList";
	}
	
}
