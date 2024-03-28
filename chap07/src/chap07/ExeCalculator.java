package chap07;

// Calculator 인터페이스를 구현하는 ExeCalculator 클래스
public class ExeCalculator implements Calculator {
    
    private Calculator delegate; // Calculator 인스턴스를 저장하기 위한 변수
    							 	//imp, rec 둘 다 받으려고     //필드선언은 필수임
    // 생성자를 통해 delegate 변수를 초기화  //의존성주입
    public ExeCalculator(Calculator delegate) {
        this.delegate = delegate; 
    }
    
    // Calculator 인터페이스에서 정의된 factorial 메서드를 재정의
    @Override
    public long factorial(long num) {       //계산의 기능을 시간측정으로
        long start = System.nanoTime(); // 시작 시간 측정
        long result = delegate.factorial(num); // delegate를 통해 factorial 계산
        long end = System.nanoTime(); // 종료 시간 측정
        System.out.printf("ImpCalculator.fac(%d) 실행시간= %d\n", num, (end - start)); // 실행 시간 출력
        return result; // 계산된 팩토리얼 값을 반환
    }
}