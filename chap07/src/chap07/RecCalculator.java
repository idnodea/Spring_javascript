package chap07;

// Calculator 인터페이스를 구현하는 ReCalculator 클래스
public class RecCalculator implements Calculator {
    
    // 재귀적으로 factorial 메서드를 구현 -자기가 자기를 호출
    @Override
    public long factorial(long num) {
        if (num == 0) {
            return 1; // 0!은 1이므로 1을 반환
        }
        return num * factorial(num - 1); // 재귀 호출을 통해 팩토리얼 계산
    }
}