package constroller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.LoginRequest;

@Controller
public class MyController {
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/hello")    //요청
	public String hello() {   //메서드 이름
		return "hello";     // 메소드이름 상관없음
//		return "redirect:/hello";   //view의 이름
	}
	
	@GetMapping("loginForm")  //요청
	public String loginForm() {
		return "inputForm";  //파일이름
	}
	
//	@GetMapping("/result")     //찾아가는 건 겟매핑
//	public String result() {
//		return "result";       //인풋폼(파일이름)-로그인폼(요청명)에 있는 폼(액션은 리절트)를 거쳐서, 
//								//result가 뜨는데
//	}
//	@GetMapping("/result")     //찾아가는 건 겟매핑
//	public String result(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		System.out.println(id);
//		
//		return "result";       //인풋폼(파일이름)-로그인폼(요청명)에 있는 폼(액션은 리절트)를 거쳐서, 
//								//result가 뜨는데
//	}
	
//	@GetMapping("/result")     //찾아가는 건 겟매핑
//	public String result(@RequestParam String id, @RequestParam String email) {
//		System.out.println(id);
//		System.out.println(email);
//		return "result";
//	}
	@GetMapping("/result")     //찾아가는 건 겟매핑
	public String result(LoginRequest loginRequest) {
//		System.out.println(id);
		System.out.println(loginRequest.getId());
//		System.out.println(email);
		System.out.println(loginRequest.getEmail());
		return "result";
	}
	
//		String id = Request.getParameter("id");
//		System.out.println(id);
//		
//		return "result";       //인풋폼(파일이름)-로그인폼(요청명)에 있는 폼(액션은 리절트)를 거쳐서, 
//								//result가 뜨는데
//	}
	
	
	@GetMapping("/result2")     //찾아가는 건 겟매핑-폼액션명인듯?
	public String result2() {  //메서드명이라 상관없음
		return "result";       //인풋폼(파일이름)-로그인폼(요청명)에 있는 폼(액션은 리절트)를 거쳐서, 
								//result가 뜨는데, 이건 파일이름이 되겠네요
	}
	@GetMapping("move")
	public String move() {
		return "move";
	}
}
