package anno1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class MyObject {
	@MyAnnotation
	public void testMethod1() {
		System.out.println("@Target({ElementType.METHOD}). 타입이 메서드");
	}
	
	
	public void testMethod2() {
		System.out.println("@Target({ElementType.METHOD}). 타입이 메서드(0313)");
	}
}
