package com.choe.dao;

import java.util.ArrayList;

import com.choe.dto.AttachFileDTO;
import com.choe.dto.noticeDTO;
import com.choe.service.Criteria;

public interface noticeDAO {
	
	// 공지사항 글 작성
	public void noticeWrite(noticeDTO ndto);
	
	// 공지사항 목록
	public ArrayList<noticeDTO> noticeList(Criteria cri);
	
	// 공지사항 상세 내용 + 조회수
	public noticeDTO noticeDetail(int notice_id);
	public void noticeCntUp(int notice_id);
	
	// 공지사항 수정
	public void noticeModify(noticeDTO ndto);
	
	// 공지사항 삭제
	public void noticeRemove(int notice_id);
	
	// 공지사항 목록 페이지 처리 필요 전체건수
	public int getTotalCount(Criteria cri);
	
	public ArrayList<AttachFileDTO> attachList(int notice_id);
	
}
