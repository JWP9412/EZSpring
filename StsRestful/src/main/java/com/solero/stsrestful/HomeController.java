package com.solero.stsrestful;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
//		return "home"; //view name - view연결
		return "vipinfo"; // 홈으로 들어가면 바로 vipinfo 연결
	}
	
	@RequestMapping(value="/vipinfo",method=RequestMethod.GET)
	public String vipinfo(Locale locale, Model model) {
		return "vipinfo";
	}
	
	// 자료실 등록
	@RequestMapping(value="/boardsadd.do",method=RequestMethod.GET)
	public String boardsadd(Locale locale, Model model) {
		return "boardsadd";
	}
	
	// 자료실 수정
	@RequestMapping(value="/boardsupdate.do",method=RequestMethod.GET)
	public String boardsupdate(Locale locale, Model model) {
		return "boardsupdate";
	}
	
	// 자료실 삭제
	@RequestMapping(value="/boardsdelete.do",method=RequestMethod.GET)
	public String boardsdelete(Locale locale, Model model) {
		return "boardsdelete";
	}
	
	
}
