package com.choe.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choe.dao.noticeDAO;
import com.choe.dao.FileAttachDao;
import com.choe.dto.AttachFileDTO;
import com.choe.dto.noticeDTO;

@Service
public class noticeServiceImpl implements noticeService {
	
	@Autowired
	noticeDAO ndao;
	
	@Autowired
	FileAttachDao attachdao;
	
	public void noticeWrite(noticeDTO ndto) {
		ndao.noticeWrite(ndto);
		
		if(ndto.getAttach() == null) {
			return;
		}
	}
	
	public ArrayList<noticeDTO> noticeList(Criteria cri){
		return ndao.noticeList(cri);
	}
	
	@Transactional
	public noticeDTO noticeDetail(int notice_id) {
		ndao.noticeCntUp(notice_id);
		
		// 공지사항 게시판 제목 클릭 시 카운트 +1 - 조회수 [update]
		return ndao.noticeDetail(notice_id);
	}
	
	public void noticeModify(noticeDTO ndto) {
		ndao.noticeModify(ndto);
	}
	
	public void noticeRemove(int notice_id) {
		ndao.noticeRemove(notice_id);
	}
	
	public int getTotalCount(Criteria cri) {
		return ndao.getTotalCount(cri);
	}
	
	
/*	@Override
	public ArrayList<AttachFileDTO> AttachList(int notice_id){
		return ndao.attachList(notice_id);
	}*/
}
