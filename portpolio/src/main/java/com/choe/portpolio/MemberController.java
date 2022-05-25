package com.choe.portpolio;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.choe.dto.MemberDTO;
import com.choe.dto.PageDTO;
import com.choe.service.Criteria;
import com.choe.service.MemberService;
import com.choe.service.noticeService;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@Autowired
	MemberService mservice;
	
	@Autowired
	noticeService nservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// localhost:8080/member/member member 폴더 주소로 member.jsp 실행
	@RequestMapping(value="member",method=RequestMethod.GET)
	public String memberGet(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "/member/member";
	}
	
	// member.jsp에서 사용자가 입력한 아이디, 비밀번호, 이름을
	// 데이터를 수집.
	@RequestMapping(value="memberWrite",method=RequestMethod.POST)
	public String memberPost(MemberDTO mdto, Model model) {
		System.out.println(mdto);
		mservice.MemberInsert(mdto);
		
		if(mdto != null) {
			return "redirect:/member/login";
		}else {
			return "/member";
		}
	}
	
	// localhost:8080/member/login 주소로
	// member폴더 안에 있는 login.jsp를 실행
	@RequestMapping(value="member/login",method=RequestMethod.GET)
	public void loginGet(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
	}
	
	@RequestMapping(value="member/login", method=RequestMethod.POST)
	public String loginPost(MemberDTO mdto, HttpSession session) {
		// select된 결과 : mservice.Login(mdto)가  있으면(Null아니면)
		String result="";
//		MemberDTO log = mservice.Login(mdto);
		if(mservice.Login(mdto) != null) {
			// session영역에 select(mservice.Login(mdto))된 결과 member 변수에 저장
			session.setAttribute("session", mservice.Login(mdto));
			// 메인페이지 이동(index.jsp)
			// return "redirect:/"; // 홈컨트롤에 있는 벨류 /를 찾아 index를 찾아감
			result ="redirect:/main";
		} else { // 그렇지 않으면, mservice.Login(mdto) 결과가 없으면 null 아니면
		// 로그인 페이지(member/login.jsp로 이동을 하면 됨
			session.setAttribute("errMsg", "로그인 정보가 올바르지 않습니다.");
			result ="redirect:/member/login";
		}
		return result;
	}
	
	// localhost:8080/member/login 주소로
	// member폴더 안에 있는 login.jsp를 실행
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public String adminGet(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		
		return "/admin/login";
	}
	
	@RequestMapping(value="admin/login", method=RequestMethod.POST)
	public String adminPost(MemberDTO adto, HttpSession session) {
		// select된 결과 : mservice.Login(mdto)가  있으면(Null아니면)
		String result="";
//		MemberDTO log = mservice.Login(mdto);
		if(mservice.AdminLogin(adto) != null) {
			// session영역에 select(mservice.Login(mdto))된 결과 member 변수에 저장
			session.setAttribute("session", mservice.AdminLogin(adto));
			// 메인페이지 이동(index.jsp)
			// return "redirect:/"; // 홈컨트롤에 있는 벨류 /를 찾아 index를 찾아감
			result ="redirect:/admin/main";
		} else { // 그렇지 않으면, mservice.Login(mdto) 결과가 없으면 null 아니면
			
			result ="redirect:/admin";
		}
		return result;
	}
	
	@RequestMapping(value="admin/main",method=RequestMethod.GET)
	public String adminMain(Model model, Criteria cri, MemberDTO adto, MemberDTO mdto) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		
		if(mservice.AdminLogin(adto) != null) {
			return "redirect:/admin";
		}
		return "/admin/adminmain";
	}
	
	 @RequestMapping(value ="/idcheck.do/{m_id}", method=RequestMethod.GET, consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	    public ResponseEntity<String> idcheck(@PathVariable("m_id") String m_id) {
	        System.out.println("m_id 는 "+m_id);
	        if(mservice.idcheck(m_id) != null) {
	        	return new ResponseEntity<>("success",HttpStatus.OK);
	        }else {
	        	return new ResponseEntity<>("false",HttpStatus.OK);
	        }
	    }
	
	// 로그아웃
	@RequestMapping(value="member/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
}