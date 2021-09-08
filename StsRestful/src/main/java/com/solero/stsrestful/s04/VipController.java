/*
 * 응답코드 전송
 * HttpStatus
 */
package com.solero.stsrestful.s04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController이것만 기억!
@RestController 
@RequestMapping("/vip/*")
public class VipController { // rests/hello
	
	
	@RequestMapping("/viplist.do")
	public ResponseEntity<List<VipVO>> listVips(){
		List<VipVO> users = new ArrayList<VipVO>();
		for(int cnt=0; cnt <10 ; cnt++) {
			VipVO vo = new VipVO();
			vo.setId("vip-"+cnt);
			vo.setPwd("1234-"+cnt);
			vo.setName("vuser: "+cnt);
			vo.setEmail("hgd" + cnt + "@vip.com");
			vo.setAge(30 + cnt);
			
			users.add(vo);
		}
		return new ResponseEntity(users, HttpStatus.CREATED); //201
//		return new ResponseEntity(users, HttpStatus.INTERNAL_SERVER_ERROR);//500
	}
	
	@RequestMapping(value="/vipinfo.do", method=RequestMethod.POST)
	public String vipInfo(@RequestBody VipVO vipVO) {
		System.out.println("[VipController]");
		System.out.println(vipVO.toString());
		return "vipinfo success!!";
	}
	
	
	
}
