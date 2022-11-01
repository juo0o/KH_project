package kh.study.intranet.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class mainController {
	
	@RequestMapping("/mainPage")
	public String mainPage() {
		
		return "/main/mainPage";
	}

}
