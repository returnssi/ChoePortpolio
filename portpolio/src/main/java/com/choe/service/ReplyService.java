package com.choe.service;

import java.util.ArrayList;

import com.choe.dto.ReplyDTO;

public interface ReplyService {
	// 댓글 쓰기
	public int add(ReplyDTO rdto);
	// 댓글 목록 리스트
	public ArrayList<ReplyDTO> list(int qna_id);
	// 댓글목록 리스트 클릭 후 띄워지는 모달창에 select된 결과 뿌리기
	public ReplyDTO detail(int qreply_no);
	//댓글내용 수정
	public int modify(ReplyDTO rdto);
	// 댓글내용 삭제
	public int remove(int qreply_no);
}
