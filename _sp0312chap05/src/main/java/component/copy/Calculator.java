package component.copy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//calculator.java

@Component
//@Repository
public class Calculator {
//더하기
	public Double add(double x, double y) {
		return x+y;
	}
	
	
}
