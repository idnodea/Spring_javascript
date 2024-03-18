package ramda;

public class MyFunctionalInterfaceEx {

	public static void main(String[] args) {
//		MyFunctionalInterface f1;
		MyFunctionalInterface f1,f2;
		
		f2 = new MyFunctionalInterface() {
			
			@Override
			public int method(int x, int y) {
				return sum(x,y);
			}
		};
//		f1 = (x, y)-> {
//			
//			return x+y;
//		};
//		int z = f1.method(10, 20);
//		System.out.println(z);
//	}
		
//		f1  = (x,y) -> x+y;
//		f1  = (a,b) -> { sum(b,a)};
		f1  = (x,y) -> {return sum(x,y);};
		System.out.println(f1.method(10, 20));
		System.out.println(f2.method(100, 200));
	}
	
	public static int sum(int x, int y) {
		return x+y;
	}
	
}
