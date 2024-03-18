package anno1;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Method[] methodList = MyObject.class.getMethods(); //클래스이름 Myobject
															//클래스.정의된메서드
		
		for(Method method : methodList) {
//			System.out.println(method);   //여기까진 메서드 1,2
			if(method.isAnnotationPresent(MyAnnotation.class)) { //어노테이션이있을
				System.out.println(method);   //메서드1만 찍힘(@anootation있는것만찍히는걸 알 수 있음											//
				
				MyAnnotation annotation = method.getDeclaredAnnotation(MyAnnotation.class);
//				String value = annotation.value();
				String value = annotation.value123();
				System.out.println(method.getName()+":"+value);
			}
		}
	}

}
