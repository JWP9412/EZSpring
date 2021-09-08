package com.solreo.stsBoot1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hellopage.do")
	public String hellopage(Model model) {
		System.out.println("[hellopage]");
		model.addAttribute("message","Hello,Spring Boot JSP!!!");
		return "hellopage";
	}
}
