package com.choe.portpolio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.choe.dto.ReplyDTO;
import com.choe.service.ReplyService;

@RestController
public class ReplyController {
	@Autowired
	ReplyService rservice;
	// consumes, produces 선택사항(명시하지 않아도 됨, 명시를 하지 않으면 웹브라우저가 알아서 판단을 해서 타입을 결정)
	// consumes : 화면(클라이언트) -> 서버에게 보내는 데이터 타입을 명시
	// produces : 서버 -> 화면(클라이언트)에게 반환하는 데이터 타입을 명시
	@RequestMapping(value="/replies/new", method=RequestMethod.POST, consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> add(@RequestBody ReplyDTO rdto) {
		int result = rservice.add(rdto);
		
		// result값이 1이면 정상처리
		return result == 1?new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>("success", HttpStatus.OK);
		// 그렇지 않으면 에러처리
	}
	@RequestMapping(value="/replies/list/{qna_id}", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ArrayList<ReplyDTO>> list (@PathVariable("qna_id") int qna_id){
		System.out.println(qna_id);
		// reply.js에 ajax 함수의 success에 보내라
		return new ResponseEntity<>(rservice.list(qna_id),HttpStatus.OK);
	}
	
	// 댓글목록리스트를 클릭한 후 띄워지는 모달창에 select된 결과 뿌리기
	@RequestMapping(value="/replies/detail/{qreply_no}", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ReplyDTO> detail(@PathVariable("qreply_no") int qreply_no){
		return new ResponseEntity<>(rservice.detail(qreply_no),HttpStatus.OK);
	}
	//댓글내용 수정
	@RequestMapping(value="/replies/modify", method=RequestMethod.PUT, consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyDTO rdto) {
//		System.out.println(rdto);
		int result=rservice.modify(rdto); // update가 되었으면 1값, 안되었으면 0값을 Result에 저장
		// 조건 ? 참 : 거짓
		return result==1?new ResponseEntity<>("success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	// 댓글내용이 삭제되는 delete
	@RequestMapping(value="/replies/remove/{qreply_no}", method=RequestMethod.DELETE, produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("qreply_no") int qreply_no){
		int result = rservice.remove(qreply_no);
		
		return result==1?new ResponseEntity<>("success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
