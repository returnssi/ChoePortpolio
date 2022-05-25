package com.choe.service;

import com.choe.dto.MemberDTO;

public interface MemberService {
	// 회원가입 화면에서 회원가입 버튼을 클릭했을 때 member 테이블 insert
	public void MemberInsert(MemberDTO mdto);
	// 로그인 화면에서 로그인 버튼을 클릭했을 때 member 테이블 select
	public MemberDTO Login(MemberDTO mdto);
	// 관리자 로그인 화면에서 로그인 버튼을 클릭했을 때 member 테이블 select
	public MemberDTO AdminLogin(MemberDTO adto);
	
	public MemberDTO idcheck(String m_id);
}
