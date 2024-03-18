package anno2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import anno1.MyAnnotation; // 다른 패키지의 MyAnnotation 클래스를 import


public class Main {
    
//    public static void main(String args[]) throws NoSuchMethodException, SecurityException {
    public static void main(String args[]) throws Exception {
    	
    	//2줄과
//    	Target ta = new Target();
//    	ta.sub123();
    	
    	//이 4줄은 같음, 라이브러리처럼 쓸 수 있어서  윗2줄보다 좋다고 생각함
    	String className = "anno2.Target";
    	Class<?> cls =Class.forName(className);
    	Target a =(Target) cls.getDeclaredConstructor().newInstance(0);
    	a.sub123();
    	
    	
    	//특정 메서드의 어노테이션을 가져올 수 있습니다
    	//        Method method = Target.class.getMethod("sub123");
//        Method method = Target.class.getMethod("sub");
//    	  Annotation[] annotations = method.getDeclaredAnnotations();
    	  Method[] methods = cls.getDeclaredMethods();
    	
    	  
    	  for(int i=0; i<methods.length; i++) {   //0313 2교시 추가
    		  if(methods[i].isAnnotationPresent(MyAnno.class)) {
    			  MyAnno myAnno = methods[i].getAnnotation(MyAnno.class);
    			  System.out.println(myAnno.value());
    		  }
    		  if(methods[i].isAnnotationPresent(MyAnnotation.class)) { //어노테이션이있을
  				System.out.println(methods);   //메서드1만 찍힘(@anootation있는것만찍히는걸 알 수 있음											//
  				
  				MyAnnotation annotation = methods[i].getDeclaredAnnotation(MyAnnotation.class);
//  				String value = annotation.value();
  				String value = annotation.value123();
  				System.out.println(methods[i].getName()+":"+value);
  			}
    		  
    	  }
    	  
    	  
//        for(Annotation anno: annotations) {
//            if (anno instanceof MyAnno) {
//                MyAnno myAnno = (MyAnno) anno;
////                System.out.println(myAnno.value());
//                System.out.println(myAnno.value());
//            }
//        }
    }
}