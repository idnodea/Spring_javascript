package com.sky.sp0320.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.sp0320.service.MemberService;

@Controller
public class AjaxController { //이름의미x  //컨트롤러 두개 이상있어도 되지만, 같은거 x
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/ajax1")
	public String ajax1() {
		return "ajax1";
	}
	
	@GetMapping("list2")
	public String list2(Model model) {
		model.addAttribute("list2",memberService.listAll());
		return "list2";
	}

}
