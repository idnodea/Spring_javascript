package chap07;

// Calculator 인터페이스를 구현하는 ImpCalculator 클래스
public class ImpCalculator implements Calculator {
    
    // Calculator 인터페이스에서 정의된 factorial 메서드를 재정의
    @Override
    public long factorial(long num) {
//    	long start = System.currentTimeMillis();   //원래의 기능은 아님. 팩토리얼은 계산해주는 기능이니까.
//    	long start = System.nanoTime();
        long result = 1;
        for (long i = 1; i <= num; i++) { // 팩토리얼을 계산하기 위한 루프
            result *= i; // 1부터 num까지의 각 숫자를 곱함
        }
        
//        long end = System.currentTimeMillis();
//        System.out.printf("ImpCalculator.fac(%d) 실행시간= %d\n", num, (end - start));
        return result; // 계산된 팩토리얼 값을 반환
    }
}