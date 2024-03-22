package com.sb0322.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sb0322.dto.MemberDto;
import com.sb0322.service.MemberService;



@Controller
public class MyController {

//	@Autowired
//	private MemberDao memberDao;

	@Autowired
	private MemberService memberService;

	@GetMapping("/")
	public String root() {
//		System.out.println(memberDao.count());

//		model.addAttribute("list", memberService.listAll());
		return "index";
	}

	@GetMapping("/index")
	public String index() {
//		System.out.println(memberDao.count());

//		model.addAttribute("list", memberService.listAll());
		return "index";
	}

	@PostMapping("/view")
	public String memo(Model model) {
//		System.out.println(memberDao.count);
//		model.addAttribute("str","DB값");
//		model.addAttribute("count",memberDao.count());

		System.out.println(" memberService.selectAll()" + memberService.selectAll());
		model.addAttribute("list", memberService.selectAll());
		return "view";

	}

	@PostMapping("/input")
	public String input(Model model, MemberDto member) {
//		System.out.println(memberDao.count);
//		model.addAttribute("str","DB값");
//		model.addAttribute("count",memberDao.count());
//		System.out.println("회원번호는:"+memberno+"입니다");
		
//		System.out.println("회원번호는:"+memberno+"입니다");
		
		System.out.println("신규데이터가 입력되었습니다" + member);
		memberService.insert(member);
		model.addAttribute("list", memberService.selectAll());
		return "view";
		
		
		
		

	}

//	@GetMapping("/update")
//	public String update(Model model,int memberno) {
//		
//		model.addAttribute("list", memberService.selectAll());
//		return "updateForm";
//		
//	}
	@PostMapping("/update")
	public String update(Model model, int memberno,  String name,  int age,
			 String email,  String memo) {
		MemberDto member = new MemberDto(memberno, email, age, name, memo );
		memberService.update(member);
		model.addAttribute("list", memberService.selectAll());
		return "view";

	}

	@GetMapping("/updateForm")
	public String updateForm( Model model, @RequestParam int memberno) {

		model.addAttribute("member", memberService.findByMemberno(memberno));
		model.addAttribute("list", memberService.selectAll());
//		return "updateForm";
		return "view";

	}

	@GetMapping("/delete")
	public String delete(Model model, @RequestParam int memberno) {
		System.out.println("데이터삭제");

		memberService.delete(memberno);
		model.addAttribute("list", memberService.selectAll());
		return "view";
	}

	@GetMapping("/deleteForm")
	public String deleteForm(Model model, int memberno) {

		model.addAttribute("member", memberService.findByMemberno(memberno));
		model.addAttribute("list", memberService.selectAll());
//		return "deleteForm";
		return "view";

	}
	
	@GetMapping("/memoUpdate")
	public String memoUpdate(@RequestParam("memberno") int memberno, @RequestParam("memo") String memo, Model model) {
	    memberService.memoUpdate(memberno, memo);
	    model.addAttribute("list", memberService.selectAll());
	    return "view"; // 업데이트 후 목록 페이지로 리디렉션
	}

	@GetMapping("/memoDelete")
	public String memoDelete(@RequestParam("memberno") int memberno, Model model) {
	    memberService.memoDelete(memberno);
	    model.addAttribute("list", memberService.selectAll());
	    return "view"; // 삭제 후 목록 페이지로 리디렉션
	}
	
	
	
//	@GetMapping("/memoUpdate")
//	public String memoUpdate(String memo, Model model) {
//	    // 메모 업데이트 로직을 여기에 구현
//	    // 예: memberService.updateMemo(memberno, memo);
//		model.addAttribute("list", memberService.selectMemo());
//	    return "view"; // 업데이트 후 목록 페이지로 리디렉션
//	}
//
//	@GetMapping("/memoDelete")
//	public String memoDelete(String memo,Model model) {
//	    // 메모 삭제 로직을 여기에 구현
//	    // 예: memberService.deleteMemo(memberno);
//		model.addAttribute("list", memberService.selectMemo());
//	    return "view"; // 삭제 후 목록 페이지로 리디렉션
//	}
//	@GetMapping("/memoUpdate")
//	public String memoUpdate(Model model, int memberno) {
//		System.out.println("메모수정");
//
//		model.addAttribute("list", memberService.selectAll());
//		return "view";
//
//	}
//
//	@GetMapping("/memoDelete")
//	public String memoDel(Model model, int memberno) {
//		System.out.println("메모삭제");
//		model.addAttribute("list", memberService.selectAll());
//		return "view";
//
//	}

//	@PostMapping("/updateMemo")
//	public String updateMemo(@RequestParam("id") String id, @RequestParam("memo") String memo, RedirectAttributes redirectAttrs) {
//	    // 메모 업데이트 로직 구현
//	    // 예: memberService.updateMemo(id, memo);
//	    
//	    redirectAttrs.addFlashAttribute("message", "메모가 성공적으로 업데이트되었습니다.");
//	    return "redirect:/memoListPage"; // 메모 목록 페이지로 리다이렉트
//	}
//	
//	@GetMapping("/deleteMemo")
//	public String deleteMemo(@RequestParam("id") String id, RedirectAttributes redirectAttrs) {
//	    // 메모 삭제 로직 구현
//	    // 예: memberService.deleteMemoById(id);
//	    
//	    redirectAttrs.addFlashAttribute("message", "메모가 성공적으로 삭제되었습니다.");
//	    return "redirect:/memoListPage"; // 메모 목록 페이지로 리다이렉트
//	}
}
