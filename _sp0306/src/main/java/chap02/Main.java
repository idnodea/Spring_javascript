package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		//객체생성하는 공장역할
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
														//앱컨텐스트 클래스를 읽어옴
		
		
		Greeter g = ctx.getBean("greeter",Greeter.class);
		String msg = g.greet("스프링"); //초기화
		System.out.println(msg);
		ctx.close();
	}
}
