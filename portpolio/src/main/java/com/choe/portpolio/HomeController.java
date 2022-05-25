package com.choe.portpolio;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choe.dto.PageDTO;
import com.choe.service.Criteria;
import com.choe.service.noticeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	noticeService nservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
/*		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		
		return "index";
	}
	
	@GetMapping(value = "/main")
	public String main(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "main";
	}
	
	@GetMapping(value = "/aboutme")
	public String aboutme(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "aboutme";
	}
	
	@GetMapping(value = "/project")
	public String project(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "project";
	}
	
	@GetMapping(value = "/pdf")
	public String pdf(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "pdf";
	}
	
	@GetMapping(value = "/history")
	public String board(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "history";
	}
	
	@GetMapping(value = "/testing")
	public String testing(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
		return "testing";
	}
	
	
    @GetMapping(value = "/Error/error400")
    public String Error400(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
        return "Error/error400";
    }
	
    @GetMapping(value = "/Error/error404")
    public String Error404(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
        return "Error/error404";
    }
    
    @GetMapping(value = "/Error/error405")
    public String Error405(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
        return "Error/error405";
    }
    
    @GetMapping(value = "/Error/error500")
    public String Error500(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
        return "Error/error500";
    }
    
    @GetMapping(value = "/Error/error503")
    public String Error503(Model model, Criteria cri) {
		System.out.println(nservice.noticeList(cri));
		model.addAttribute("nlist", nservice.noticeList(cri));
		
		//noticeList.jsp에 페이징 처리를 하기 위한 데이터를 noticeList.jsp에 보내고자 함
		model.addAttribute("PageMaker", new PageDTO(cri, nservice.getTotalCount(cri)));
        return "Error/error503";
    }
}
