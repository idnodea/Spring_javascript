package practice;

import java.util.Optional;

class Bbb{
	int x;
	public Bbb(int x) {
		this.x = x;
	}
	
	void print() {
		System.out.println("Bbb");
		System.out.println("Bbb"+x);
	}
}
class Aaa{
	void print(Bbb bb) {
		bb.print();
//		bb1.print();
	}
}

public class OptionalMain {

	public static void main(String[] args) {
		Aaa aa = new Aaa();
//		Bbb bb = new Bbb(100);   //두번째의 첫번째
		Bbb bb = null;   //두번째의 두번째
//		Bbb bb = null;   //가정: 값이 예상안되는 값이라 null로 가정
//		if(bb == null) {
//			System.out.println("bb가 null입니다");
//		}else {
//			aa.print(bb);
//		}
		//위의 코드를 옵셔널로
//		Optional<Bbb> bb1 = Optional.ofNullable(bb);
		Optional<Bbb> bb1 = Optional.ofNullable(bb);
		System.out.println(bb1);
//		aa.print(bb1);
//		aa.print(bb1.orElseGet(()->new Bbb())); //람다식
		aa.print(bb1.orElseGet(()-> new Bbb(0))); //람다식
			
		//		aa.print(null);
//		bb1.ifPresentOrElse(
//	            // 만약 값이 존재하면 print를 호출하고
//	            // 아니면 새로운 Bbb 객체를 만들고 print를 호출
//	            b -> aa.print(b),
//	            () -> {
//	                System.out.println("bb가 null입니다");
//	            }
//	        );
		
		
	}

}
