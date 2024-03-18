package autoEx;

import java.security.PublicKey;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppContext.class);
		Car c = ctx.getBean("car",Car.class);
		c.run();
		
		ctx.close();
		
		
		//아까 만들었던 앱컨텍스트 의존성주입이 안되어서
		//그럼 오토와이어드도 붙여주어야겠네요
		
		//엔진에 붙여주고
		//카에 붙여주고
		
		//이후에 실행하는 코드를
		
		
	}

}
