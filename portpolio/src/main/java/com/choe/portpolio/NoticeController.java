package com.choe.portpolio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

import com.choe.dto.AttachFileDTO;
import com.choe.dto.noticeDTO;
import com.choe.dto.PageDTO;
import com.choe.service.noticeService;
import com.google.gson.JsonObject;
import com.choe.service.Criteria;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class NoticeController {
	@Autowired
	noticeService nservice;
	
	
	// 게시판 글쓰기 화면을 실행하기 위함.
	@RequestMapping(value="/notice/write", method=RequestMethod.GET)
	public String noticeWrite(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "notice/noticeWrite";
	}
	
	// 게시판 글쓰기 화면에서 실제로 글쓰기가 이루어지는 것
	@RequestMapping(value="/notice/write", method=RequestMethod.POST)
	public String noticeWritePost(noticeDTO ndto) {
		System.out.println("notice/write");
		System.out.println(ndto);
		
//		bservice.noticeWrite(ndto);
		if(ndto.getAttach()!=null) {
			ndto.getAttach().forEach(attach->System.out.println(attach));
		}
		nservice.noticeWrite(ndto);
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value= "/notice/list", method=RequestMethod.GET)
	// Model : Controller에서 .jsp로 데이터를 전송하는 역활
	public String noticeListGet(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "notice/noticeList";
	}
	
	@RequestMapping(value="/notice/detail", method=RequestMethod.GET)
	public String noticeDetailGet(int notice_id, Model model, Criteria cri) {
		System.out.println(notice_id);
		model.addAttribute("nlist", nservice.noticeList(cri));
		model.addAttribute("ndetail", nservice.noticeDetail(notice_id));
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "notice/noticeDetail";
	}
	
	// noticeDetail.jsp에서 수정버튼을 클릭했을 때 수정 할 수 있는 화면으로 이동
	@RequestMapping(value="/notice/modify", method=RequestMethod.GET)
	public String noticeModifyGet(int notice_id, Model model, Criteria cri) {
		System.out.println(notice_id);
		model.addAttribute("nlist", nservice.noticeList(cri));
		model.addAttribute("ndetail", nservice.noticeDetail(notice_id));
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		model.addAttribute("modify", nservice.noticeDetail(notice_id));
		return "/notice/noticeModify";
	}
	
	// noticeModify.jsp에서 수정버튼을 누르면 실제 update가 실행되게 하기
	@RequestMapping(value="/notice/modify", method=RequestMethod.POST)
	public String noticeModifyGet(noticeDTO ndto) {
//		return "";
		// update할 수 있게 DAO연결
		nservice.noticeModify(ndto);
		System.out.println("갖고오나: "+ndto.getNotice_id());
		// noticeDetail.jsp를 실행
		// detail의 select결과를 실행하고 난 후, noticeDetail.jsp를 실행 (redirect)
		return "redirect:/notice/detail?notice_id="+ndto.getNotice_id();
	}
	
	// noticeDetail.jsp에서 삭제버튼을 클릭하면 실제 delete가 실행 되게 하기
	@RequestMapping(value="/notice/remove", method=RequestMethod.GET)
	public String noticeRemoveGet(int notice_id) {
		nservice.noticeRemove(notice_id);
		// detail의 select결과를 실행하고 난 후, noticeList.jsp를 실행 (redirect)
		return "redirect:/notice/list";
	}
	
	@PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
	@ResponseBody
	public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
		
		JsonObject jsonObject = new JsonObject();
		
		String fileRoot = "C:\\summernote_image\\";	//저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
				
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
