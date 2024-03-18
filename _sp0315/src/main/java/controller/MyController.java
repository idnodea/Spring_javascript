package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dto.MemberDto;
import service.GetMemberNumService;

@Controller
public class MyController {  //폼에서 겟에서->포스트
	
	@Autowired
	private GetMemberNumService getMemberNumService;
	
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@PostMapping("/login")   //로그인관련만 포스트로
	public String login(MemberDto memberdto,Model model)		{   
		String member = "test1";
		System.out.println(memberdto.getId());
		System.out.println(memberdto.getPw());
		System.out.println((getMemberNumService.getNumRecords()));
		model.addAttribute("test1",member);
		return "mainPage";
	}
	
	@GetMapping("home")
	public String home() {
		return "redirect:/";
	}
}
