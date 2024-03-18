package component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
//@Service
public class UserService {
	
	private Calculator calculator;
	

	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}


	public void cal(double a, double b) {
		double result = calculator.add(a, b);
		System.out.println(result);
	}
}
