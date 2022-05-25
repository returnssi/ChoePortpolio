package com.choe.dao;

import com.choe.dto.AttachFileDTO;

public interface FileAttachDao {
	
	// 파일 첨부(filegroup) INSERT
	public void qnaAttachWrite(AttachFileDTO adto);
	
	public void updateAttach(int isImage);
	
//	public void noticeAttachWrite(AttachFileDTO adto);
	
}
