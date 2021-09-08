package com.solero.stsrestful.s02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/user.do")
	public ModelAndView user() {
		return new ModelAndView("user");
	}
	
	@ResponseBody
	@RequestMapping(value = "/userest.do")
	public Map<String, Object> userest(){
		Map<String, Object> usermap = new HashMap<String, Object>();
		usermap.put("id", "ez");
		usermap.put("name", "이젠아카데미");
		usermap.put("과정", "자바서버개발자코스");
		return usermap;
	}
}
