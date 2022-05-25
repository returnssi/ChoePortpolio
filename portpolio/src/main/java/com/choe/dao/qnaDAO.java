package com.choe.dao;

import java.util.ArrayList;

import com.choe.dto.AttachFileDTO;
import com.choe.dto.qnaDTO;
import com.choe.service.Criteria;

public interface qnaDAO {
	
	// QnA 글 작성
	public void qnaWrite(qnaDTO qdto);
	
	// QnA 목록
	public ArrayList<qnaDTO> qnaList(Criteria cri);
	
	// QnA 상세 내용
	public qnaDTO qnaDetail(int qna_id);
	
	// QnA 수정
	public void qnaModify(qnaDTO qdto);
	
	// QnA 삭제
	public void qnaRemove(int qna_id);
	
	// QnA 목록 페이지 처리 필요 전체건수
	public int getTotalCount(Criteria cri);
	public ArrayList<AttachFileDTO> attachList(int qna_id);
	
}
