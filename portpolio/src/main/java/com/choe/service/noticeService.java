package com.choe.service;

import java.util.ArrayList;

import com.choe.dto.AttachFileDTO;
import com.choe.dto.noticeDTO;

// 설계
public interface noticeService {
	// 공지사항 글 쓰기
	public void noticeWrite(noticeDTO ndto);
	
	// 공지사항 목록
	public ArrayList<noticeDTO> noticeList(Criteria cri);
	
	// 공지사항 제목 클릭시 상세 내용
	public noticeDTO noticeDetail(int notice_id);
	
	// 공지사항 수정
	public void noticeModify(noticeDTO ndto);
	
	// 공지사항 삭제
	public void noticeRemove(int notice_id);
	
	// 공지사항 목록 페이징 처리
	public int getTotalCount(Criteria cri);
	
}
