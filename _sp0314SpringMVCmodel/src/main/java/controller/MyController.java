package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dao.MemberDao;
import dto.LoginDto;
import dto.MemberDto;
import service.GetMemberNumService;




@Controller
public class MyController {  //폼에서 겟에서->포스트
	
	@Autowired
	private GetMemberNumService getMemberNumService;
	
//	@Autowired
//	private MyController(GetMemberNumService getMemberNumService){
////	GetMemberNumService getMemberNumService() 
//	this.getMemberNumService =getMemberNumService;
//	}; 
	//this.getMemberNumService = getMemberNumService; 구문에서
//	this.getMemberNumService는 클래스 필드를, 
//	getMemberNumService는 생성자의 매개변수를 가리킵니다.
//	이렇게 함으로써, 매개변수로 전달받은 값을 클래스 필드에 할당할 수 있습니다.
	
	
	//최상위의 루트-인덱스설정
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	//요청이름이 같아도 겟이냐 포스트냐에 따라 다르면, 다르게 인식함
		@GetMapping("/loginF")	//요청이름
		public String LoginF() {//메서드이름-별상관없
			return  "loginForm";			//파일이름
		}
		
		
		@PostMapping("/login")   
		public String log_info(LoginDto loginRequest, Model model){   //Dto의 매개변수를 써야합니다
																//model은 지원기능
			String str = "가나다";
			System.out.println(loginRequest.getId());
			System.out.println(loginRequest.getEmail());
			System.out.println(getMemberNumService.getNumRecords()); //서비스오류같은데? 어떻게 해결?
//			System.out.println(GetMemberNumService.class); //서비스오류같은데? 어떻게 해결?
			model.addAttribute("str",str);  //원래 지역변수라 값못넘기는데,  죽으면서 넘겨지게끔
			
			return "mainPage";   //실수하지말자.
		}
//		@GetMapping("/login")     //찾아가는 건 겟매핑
//		public String result(@RequestParam String id, @RequestParam String email) {
//			System.out.println(id);
//			System.out.println(email);
//			return "result";
//		}
		
		
		
		
		@GetMapping("home")
		public String home() {
//			 return "index";
			return "redirect:/";
			 // 이제 이 메서드는 "/home" 경로로 요청이 왔을 때 "index.jsp"를 렌더링합니다.
		}
}
