package com.soluser.spboards.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.soluser.spboards.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws Exception;
	 
	 public int updateMember(MemberVO memberVO) throws DataAccessException;
}
