package com.choe.dto;

import java.util.ArrayList;

import com.choe.dto.AttachFileDTO;

public class noticeDTO {
/*	notice_id int AUTO_INCREMENT PRIMARY KEY,
    notice_title varchar(500) not null,
    notice_content varchar(5000) not null,
    notice_wrnick varchar(50) not null,
    notice_wrid varchar(30) not null,
    notice_date datetime*/
	private int notice_id;
	private String notice_title;
	private String notice_content;
	private String notice_wrnick;
	private String notice_wrid;
	private String notice_date;
	private int notice_count;
	private ArrayList<AttachFileDTO> attach;

	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_wrnick() {
		return notice_wrnick;
	}
	public void setNotice_wrnick(String notice_wrnick) {
		this.notice_wrnick = notice_wrnick;
	}
	public String getNotice_wrid() {
		return notice_wrid;
	}
	public void setNotice_wrid(String notice_wrid) {
		this.notice_wrid = notice_wrid;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	
	public int getNotice_count() {
		return notice_count;
	}
	public void setNotice_count(int notice_count) {
		this.notice_count = notice_count;
	}
	public ArrayList<AttachFileDTO> getAttach() {
		return attach;
	}
	public void setAttach(ArrayList<AttachFileDTO> attach) {
		this.attach = attach;
	}
	
	@Override
	public String toString() {
		return "noticeDTO [notice_id=" + notice_id + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_wrnick=" + notice_wrnick + ", notice_wrid=" + notice_wrid
				+ ", notice_date=" + notice_date + ", notice_count=" + notice_count + ", attach=" + attach + "]";
	}
	
}
