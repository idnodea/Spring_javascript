package co_1.sp0321pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import co_1.sp0321pro.dto.MemberDto;
import co_1.sp0321pro.service.MemberService;

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
		
		System.out.println(" memberService.selectAll()"+ memberService.selectAll());
		model.addAttribute("list", memberService.selectAll());
		return "view";
		
	}
	@PostMapping("/input")
	public String input(Model model,MemberDto member) {
//		System.out.println(memberDao.count);
//		model.addAttribute("str","DB값");
//		model.addAttribute("count",memberDao.count());
//		System.out.println("회원번호는:"+memberno+"입니다");
		System.out.println("신규데이터가 입력되었습니다"+member);
		memberService.insert(member);
		model.addAttribute("list", memberService.selectAll());
		return "redirect:/view";
		
	}
//	@GetMapping("/update")
//	public String update(Model model,int memberno) {
//		
//		model.addAttribute("list", memberService.selectAll());
//		return "updateForm";
//		
//	}
	@PostMapping("/update")
	public String update(Model model,MemberDto member) {
//		System.out.println("데이터수정");
//		model.addAttribute("member", memberService.findById(id));
//		model.addAttribute("list", memberService.selectAll());
//		return "index";
		
		memberService.update(member);
		model.addAttribute("list", memberService.selectAll());
		 return "redirect:/view";
		
	}
	@GetMapping("/updateForm")
	public String updateForm(Model model,int memberno) {
		
		model.addAttribute("member", memberService.findByMemberno(memberno));
		model.addAttribute("list", memberService.selectAll());
		return "updateForm";
		
	}
	@PostMapping("/delete")
	public String delete(Model model,int memberno) {
		System.out.println("데이터삭제");
		
		memberService.delete(memberno);
		model.addAttribute("list", memberService.selectAll());
		return "index";
		
	}
	@GetMapping("/deleteForm")
	public String deleteForm(Model model,int memberno) {
		
		model.addAttribute("member",memberService.findByMemberno(memberno));
		model.addAttribute("list", memberService.selectAll());
		return "deleteForm";
		
	}
	
	@GetMapping("/memoUpdate")
	public String memoUpdate(Model model,int memberno) {
		System.out.println("메모수정");
		
		model.addAttribute("list", memberService.selectAll());
		return "view";
		
	}
	
	@GetMapping("/memoDel")
	public String memoDel(Model model, int memberno) {
		System.out.println("메모삭제");
		model.addAttribute("list", memberService.selectAll());
		return "view";
		
	}
	
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
