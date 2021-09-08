package com.solero.stsrestful.s01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController이것만 기억!
@RestController 
@RequestMapping("/rests/*")
public class MemberController { // rests/hello
	
	@RequestMapping("/hello.do")
	public String hello() {
		return "Hello, RESTful!!!";
	}
	
	@RequestMapping("/member.do")
	public MemberVO member() {
		MemberVO vo	= new MemberVO();	
		vo.setId("shyun");
		vo.setPwd("1234");
		vo.setName("홍길동");
		vo.setEmail("shyun@member.com");
		vo.setAge(30);
		//JSON 이용
		return vo;
	}
	@RequestMapping("/memberlist.do")
	public List<MemberVO> listMembers(){
		List<MemberVO> members = new ArrayList<MemberVO>();
		for(int cnt=0; cnt <10 ; cnt++) {
			MemberVO vo = new MemberVO();
			vo.setId("ez-"+cnt);
			vo.setPwd("1234-"+cnt);
			vo.setName("홍길동: "+cnt);
			vo.setEmail("hgd"+cnt+"@member.com");
			vo.setAge(30+cnt);
			members.add(vo);
		}
		return members;
	}
	
	@RequestMapping("/membersMap.do")
	public Map<Integer, MemberVO> mapMembers(){
		Map<Integer, MemberVO> maps = new HashMap<Integer,MemberVO>();
		for(int cnt=0; cnt <10 ; cnt++) {
			MemberVO vo = new MemberVO();
			vo.setId("ez-"+cnt);
			vo.setPwd("1234-"+cnt);
			vo.setName("홍길동: "+cnt);
			vo.setEmail("hgd"+cnt+"@member.com");
			vo.setAge(30+cnt);
			
			maps.put(cnt,vo);
		}
		return maps;
	}
	
	
	
}
