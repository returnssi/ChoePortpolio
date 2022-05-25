package com.choe.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choe.dao.FileAttachDao;
import com.choe.dao.qnaDAO;
import com.choe.dto.AttachFileDTO;
import com.choe.dto.qnaDTO;

@Service
public class qnaServiceImpl implements qnaService {
	@Autowired
	qnaDAO qdao;
	
	@Autowired
	FileAttachDao attachdao;
	
	public void qnaWrite(qnaDTO qdto) {
		qdao.qnaWrite(qdto);
		
		if(qdto.getAttach() == null) {
			return;
		}
		
		qdto.getAttach().forEach(attach->{
			attach.setQna_id(qdto.getQna_id());
			attachdao.qnaAttachWrite(attach);
		});
	}
	
	
	public ArrayList<qnaDTO> qnaList(Criteria cri){
		return qdao.qnaList(cri);
	}
	
	@Transactional
	public qnaDTO qnaDetail(int qna_id) {
		return qdao.qnaDetail(qna_id);
	}
	
	public void qnaModify(qnaDTO qdto) {
		qdao.qnaModify(qdto);
		
		if(qdto.getAttach() == null) {
			return;
		}
		
		qdto.getAttach().forEach(attach->{
			attach.setQna_id(qdto.getQna_id());
			attachdao.qnaAttachWrite(attach);
		});
	}
	
	public void qnaRemove(int qna_id) {
		qdao.qnaRemove(qna_id);
	}
	
	public int getTotalCount(Criteria cri) {
		return qdao.getTotalCount(cri);
	}
	
	public ArrayList<AttachFileDTO> AttachList(int qna_id){
		return qdao.attachList(qna_id);
	}
	
}
