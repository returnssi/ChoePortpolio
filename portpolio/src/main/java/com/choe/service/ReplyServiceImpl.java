package com.choe.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choe.dao.ReplyDAO;
import com.choe.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyDAO rdao;
	// 댓글쓰기
	public int add(ReplyDTO rdto) {
		return rdao.add(rdto);
	}
	//댓글 목록 리스트
	public ArrayList<ReplyDTO> list(int qna_id){
		return rdao.list(qna_id);
	}
	// 댓글목록 리스트 클릭 후 띄워지는 모달창에 select된 결과 뿌리기
	public ReplyDTO detail(int qreply_no) {
		return rdao.detail(qreply_no);
	}
	//댓글내용 수정
	public int modify(ReplyDTO rdto) {
		return rdao.modify(rdto);
	}
	// 댓글내용 삭제
	public int remove(int qreply_no) {
		return rdao.remove(qreply_no);
	}
}
