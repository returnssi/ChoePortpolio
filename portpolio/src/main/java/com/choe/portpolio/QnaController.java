package com.choe.portpolio;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choe.dao.qnaDAO;
import com.choe.dto.AttachFileDTO;
import com.choe.dto.MemberDTO;
import com.choe.dto.PageDTO;
import com.choe.dto.qnaDTO;
import com.choe.service.Criteria;
import com.choe.service.MemberService;
import com.choe.service.ReplyService;
import com.choe.service.noticeService;
import com.choe.service.qnaService;

@Controller
public class QnaController {

	@Autowired
	qnaService qservice;
	
	@Autowired
	noticeService nservice;
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	qnaDAO qdao;

	@RequestMapping(value= "/qna", method=RequestMethod.GET)
	// Model : Controller에서 .jsp로 데이터를 전송하는 역활
	public String qnaListGet(Model model, Criteria cri, HttpSession session, String m_id, MemberDTO mdto) {
		System.out.println(qservice.qnaList(cri));
		model.addAttribute("qlist", qservice.qnaList(cri));
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		model.addAttribute("PageMaker", new PageDTO(cri, qservice.getTotalCount(cri)));
		return "qna/qnalist";
	}
	
	@RequestMapping(value="/qna/detail", method=RequestMethod.GET)
	public String qnaDetailGet(int qna_id, Model model, Criteria cri) {
		System.out.println(qna_id);
		model.addAttribute("nlist", nservice.noticeList(cri));
		model.addAttribute("qdetail", qservice.qnaDetail(qna_id));
		model.addAttribute("PageMaker", new PageDTO(cri, qservice.getTotalCount(cri)));
		
		return "/qna/qnaDetail";
	}
//	@RequestMapping(value="/qna/pass", method=RequestMethod.GET)
//	public String qnaPass(Model model, Criteria cir, int qna_id) {
//		model.addAttribute("qdetail", qservice.qnaDetail(qna_id));
//		System.out.println("갖고 오는거 맞지? " + qna_id);
//		return "/qna/qnaPass";
//	}
	
	@RequestMapping(value="qna/write", method=RequestMethod.GET)
	public String noticeWrite(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));

		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "qna/qnaWrite";
	}
	
	// qna 게시판 글쓰기 화면에서 실제로 글쓰기가 이루어지는 것
	@RequestMapping(value="/qna/write", method=RequestMethod.POST)
	public String noticeWritePost(qnaDTO qdto) {
		System.out.println("qna/write");
		System.out.println(qdto);
		
		if(qdto.getAttach()!=null) {
			qdto.getAttach().forEach(attach->System.out.println(attach));
		}
		qservice.qnaWrite(qdto);
		return "redirect:/qna";
	}
	
	@RequestMapping(value="qna/modify", method=RequestMethod.GET)
	public String boardModifyGet(int qna_id, Model model, Criteria cri) {
		System.out.println(qna_id);
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		model.addAttribute("modify", qservice.qnaDetail(qna_id));
		return "qna/qnaModify";
	}
	
	@RequestMapping(value="/qna/modify", method=RequestMethod.POST)
	public String boardModifyGet(qnaDTO qdto) {
//		return "";
		// update할 수 있게 DAO연결
		qservice.qnaModify(qdto);
		// boardDetail.jsp를 실행
		// detail의 select결과를 실행하고 난 후, boardDetail.jsp를 실행 (redirect)
		if(qdto.getAttach()!=null) {
			qdto.getAttach().forEach(attach->System.out.println(attach));
		}
		return "redirect:/qna/detail?qna_id="+qdto.getQna_id();
	}
	
	// qna/detail 사진 보기								서버->화면에게 json형식으로 반환하는 데이터타입
	@RequestMapping(value="/attach",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.GET)
	public ResponseEntity<ArrayList<AttachFileDTO>> getAttachList(int qna_id){
		System.out.println("이게 뜨나?"+qna_id);
		qservice.AttachList(qna_id);
		return new ResponseEntity<>(qservice.AttachList(qna_id),HttpStatus.OK);
	}
		
}
