package com.choe.dto;

public class AttachFileDTO {
/*	filegroup_uuid varchar(500) PRIMARY KEY,
    filegroup_filename varchar(500) not null,
    filegroup_uploadpath varchar(3000) not null,
    filegroup_image int(2) not null,
    filegroup_qid int,
    filegroup_nid int*/
    
	private String filegroup_uuid;
	private String filegroup_filename;
	private String filegroup_uploadpath;
	private boolean filegroup_image;
	private boolean isImage;
	// 공지사항 글 작성시 글 번호 입력
	private int qna_id;
	
	public String getFilegroup_uuid() {
		return filegroup_uuid;
	}
	public void setFilegroup_uuid(String filegroup_uuid) {
		this.filegroup_uuid = filegroup_uuid;
	}
	public String getFilegroup_filename() {
		return filegroup_filename;
	}
	public void setFilegroup_filename(String filegroup_filename) {
		this.filegroup_filename = filegroup_filename;
	}
	public String getFilegroup_uploadpath() {
		return filegroup_uploadpath;
	}
	public void setFilegroup_uploadpath(String filegroup_uploadpath) {
		this.filegroup_uploadpath = filegroup_uploadpath;
	}
	public boolean isFilegroup_image() {
		return filegroup_image;
	}
	public void setFilegroup_image(boolean filegroup_image) {
		this.filegroup_image = filegroup_image;
	}
	public int getQna_id() {
		return qna_id;
	}
	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	
	public boolean isImage() {
		return isImage;
	}
	
	public void setImage(boolean isImage) {
		this.isImage = isImage;
	}
	
	@Override
	public String toString() {
		return "AttachFileDTO [filegroup_uuid=" + filegroup_uuid + ", filegroup_filename=" + filegroup_filename
				+ ", filegroup_uploadpath=" + filegroup_uploadpath + ", filegroup_image=" + filegroup_image
				+ ", isImage=" + isImage + ", qna_id=" + qna_id + "]";
	}

}
