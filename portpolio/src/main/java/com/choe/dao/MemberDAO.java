package com.choe.dao;

import com.choe.dto.MemberDTO;

public interface MemberDAO {
	public void MemberInsert(MemberDTO mdto);
	public MemberDTO Login(MemberDTO mdto);
	public MemberDTO AdminLogin(MemberDTO adto);
	public MemberDTO idcheck(String m_id);
}
