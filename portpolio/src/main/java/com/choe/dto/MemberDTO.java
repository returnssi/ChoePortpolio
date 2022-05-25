package com.choe.dto;

public class MemberDTO {
	private int m_no;
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_nickname;
	private int m_phonnumber;
	private String m_email;
	private int m_admin;
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getM_phonnumber() {
		return m_phonnumber;
	}
	public void setM_phonnumber(int m_phonnumber) {
		this.m_phonnumber = m_phonnumber;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	public String getM_name() {
		return m_name;
	}
	
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	
	public int getM_admin() {
		return m_admin;
	}
	public void setM_admin(int m_admin) {
		this.m_admin = m_admin;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [m_no=" + m_no + ", m_id=" + m_id + ", m_password=" + m_password + ", m_name=" + m_name
				+ ", m_nickname=" + m_nickname + ", m_phonnumber=" + m_phonnumber + ", m_email=" + m_email
				+ ", m_admin=" + m_admin + "]";
	}
	
}
