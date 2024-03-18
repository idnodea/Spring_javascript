package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //컴포넌트보다는 컨트롤러
public class HelloController {
//3교시
		@GetMapping("/")
		public String hello(Model model) {
			model.addAttribute("str","한글나오나");  //set 어트리뷰트대신 애드어트리뷰트(키,밸류)
			return "hello";
		}
}
