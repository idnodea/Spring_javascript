package chap07;

public class MainProxy {

	public static void main(String[] args) {
		ExeCalculator cal1 =new ExeCalculator(new ImpCalculator());
				System.out.println(cal1.factorial(20));
	
		ExeCalculator cal2 =new ExeCalculator(new RecCalculator());
				System.out.println(cal1.factorial(20));
				
//				ImpCalculator.fac(20) 실행시간= 2400
//						2432902008176640000
//						ImpCalculator.fac(20) 실행시간= 900
//						2432902008176640000

	}
	
}
