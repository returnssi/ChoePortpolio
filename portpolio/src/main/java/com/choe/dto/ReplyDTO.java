package com.choe.dto;

public class ReplyDTO {
	private int qreply_no;
	private String qreply_nickname;
	private String qreply_wrid;
	private String qreply_comment;
	private int qna_id;
	private String qreply_date;
	
	public int getQreply_no() {
		return qreply_no;
	}
	
	public void setQreply_no(int qreply_no) {
		this.qreply_no = qreply_no;
	}
	
	public String getQreply_nickname() {
		return qreply_nickname;
	}
	
	public void setQreply_nickname(String qreply_nickname) {
		this.qreply_nickname = qreply_nickname;
	}
	
	public String getQreply_wrid() {
		return qreply_wrid;
	}
	
	public void setQreply_wrid(String qreply_wrid) {
		this.qreply_wrid = qreply_wrid;
	}
	
	public String getQreply_comment() {
		return qreply_comment;
	}
	
	public void setQreply_comment(String qreply_comment) {
		this.qreply_comment = qreply_comment;
	}
	
	public int getQna_id() {
		return qna_id;
	}
	
	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	
	public String getQreply_date() {
		return qreply_date;
	}
	
	public void setQreply_date(String qreply_date) {
		this.qreply_date = qreply_date;
	}
	
	@Override
	public String toString() {
		return "ReplyDTO [qreply_no=" + qreply_no + ", qreply_nickname=" + qreply_nickname + ", qreply_wrid="
				+ qreply_wrid + ", qreply_comment=" + qreply_comment + ", qna_id=" + qna_id + ", qreply_date="
				+ qreply_date + "]";
	}
	
}
