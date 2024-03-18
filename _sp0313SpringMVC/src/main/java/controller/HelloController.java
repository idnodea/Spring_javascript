package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //컴포넌트보다는 컨트롤러
public class HelloController {
//3교시
		@GetMapping("/hello")
		public String hello() {
			return "hello";
		}
}
