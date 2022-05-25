package com.choe.dto;

import java.util.ArrayList;

import com.choe.dto.AttachFileDTO;

public class qnaDTO {
	/*	qna_id (기본키) int 글번호
	qna_title varchar(500)  글제목
	qna_content longtext 글 내용
	qna_wrnick varchar(50) 글쓴이 닉네임
	qna_wrid varchar(30) 글쓴이 아이디
	qna_date datetime 글 작성 일시
	qna_pass int 글 비밀번호*/
	private int qna_id;
	private String qna_title;
	private String qna_content;
	private String qna_wrnick;
	private String qna_wrid;
	private String qna_date;
	private int qna_pass;
	private String qna_secret;
	private ArrayList<AttachFileDTO> attach;
	
	public int getQna_id() {
		return qna_id;
	}


	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}


	public String getQna_title() {
		return qna_title;
	}


	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}


	public String getQna_content() {
		return qna_content;
	}


	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}


	public String getQna_wrnick() {
		return qna_wrnick;
	}


	public void setQna_wrnick(String qna_wrnick) {
		this.qna_wrnick = qna_wrnick;
	}


	public String getQna_wrid() {
		return qna_wrid;
	}


	public void setQna_wrid(String qna_wrid) {
		this.qna_wrid = qna_wrid;
	}


	public String getQna_date() {
		return qna_date;
	}


	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}


	public int getQna_pass() {
		return qna_pass;
	}


	public void setQna_pass(int qna_pass) {
		this.qna_pass = qna_pass;
	}

	public String getQna_secret() {
		return qna_secret;
	}


	public void setQna_secret(String qna_secret) {
		this.qna_secret = qna_secret;
	}


	public ArrayList<AttachFileDTO> getAttach() {
		return attach;
	}

	public void setAttach(ArrayList<AttachFileDTO> attach) {
		this.attach = attach;
	}

	@Override
	public String toString() {
		return "qnaDTO [qna_id=" + qna_id + ", qna_title=" + qna_title + ", qna_content=" + qna_content
				+ ", qna_wrnick=" + qna_wrnick + ", qna_wrid=" + qna_wrid + ", qna_date=" + qna_date + ", qna_pass="
				+ qna_pass + ", qna_secret=" + qna_secret + ", attach=" + attach + "]";
	}

}
