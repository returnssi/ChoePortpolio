package com.choe.service;

import com.choe.dao.MemberDAO;
import com.choe.dto.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO mdao;
	
	@Autowired
	MemberService mservice;
	
	// 회원가입 화면에서 회원가입 버튼을 클릭했을 때 member 테이블 insert
	public void MemberInsert(MemberDTO mdto) {
		mdao.MemberInsert(mdto);
	}
	// 로그인 화면에서 로그인 버튼을 클릭했을 때 member 테이블 select
	public MemberDTO Login(MemberDTO mdto) {
		// 해당 dao 연결
		return mdao.Login(mdto);
	}
	
	// 관리자 로그인 화면에서 로그인 버튼을 클릭했을 때 member 테이블에서 m_admin select
	public MemberDTO AdminLogin(MemberDTO adto) {
		return mdao.AdminLogin(adto);
	}
	
	public MemberDTO idcheck(String m_id) {
		return mdao.idcheck(m_id);
	}

}
