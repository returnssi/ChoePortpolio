package com.choe.service;

import java.util.ArrayList;

import com.choe.dto.AttachFileDTO;
import com.choe.dto.qnaDTO;

public interface qnaService {
	// QnA 글 쓰기
	public void qnaWrite(qnaDTO qdto);
	// QnA 목록
	public ArrayList<qnaDTO> qnaList(Criteria cri);
	// QnA 제목 클릭시 상세 내용
	public qnaDTO qnaDetail(int qna_id);
	// QnA 수정
	public void qnaModify(qnaDTO qdto);
	// QnA 삭제
	public void qnaRemove(int qna_id);
	// QnA 목록 페이징 처리
	public int getTotalCount(Criteria cri);
	// QnA 상세내용 첨부파일 목록 조회
	public ArrayList<AttachFileDTO> AttachList(int qna_id);
}
