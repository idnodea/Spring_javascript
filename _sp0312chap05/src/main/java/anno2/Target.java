package anno2;

import anno1.MyAnnotation;

public class Target {
	
//	@MyAnno(value ="연습입니다.")
//	@MyAnno(value ="연습입니다.")
	
	@MyAnno(value ="연습입니다.")
	@MyAnnotation(value123 = "테스트123")
	
//	public void sub() {
	public void sub123() {
		System.out.println("Target");
	}
	
}
