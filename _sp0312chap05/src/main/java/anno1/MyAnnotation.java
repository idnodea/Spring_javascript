package anno1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
//	String value() default "MyAnnotation : default value"; //문자열 리턴, 인터페이스 형식
//	String value()default "MyAnnotation : 기본값"; //0313 예시
	String value123()default "MyAnnotation : 기본값"; //0313 예시2 밸류를 가져온다
}
//이 코드는 Java에서 사용자 정의 어노테이션(@interface)을 정의하는 방법을 보여줍니다. MyAnnotation이라는 이름의 사용자 정의 어노테이션은 메서드에 적용될 수 있으며, 런타임에도 유지됩니다. 이 어노테이션은 선택적으로 value 속성을 가질 수 있으며, 기본값으로 "MyAnnotation : default value"를 제공합니다.
//
//@Target
//@Target 어노테이션은 이 사용자 정의 어노테이션이 적용될 수 있는 Java 요소의 종류를 지정합니다. 이 경우 ElementType.METHOD가 지정되어 있으므로, MyAnnotation은 메서드 선언에만 사용될 수 있습니다.
//
//@Retention
//@Retention 어노테이션은 정의된 어노테이션이 어떤 단계까지 유지될 것인지를 지정합니다. 여기서 RetentionPolicy.RUNTIME은 MyAnnotation이 런타임에도 유지되어야 함을 의미하며, 이는 리플렉션을 통해 런타임에 해당 어노테이션 정보에 접근할 수 있음을 나타냅니다.
//
//value 속성
//MyAnnotation에는 value라는 이름의 속성이 정의되어 있으며, 이는 String 타입입니다. 이 속성에는 기본값으로 "MyAnnotation : default value"가 할당되어 있으며, 어노테이션을 사용할 때 이 값을 명시적으로 제공할 수 있습니다. 기본값은 어노테이션이 해당 속성 값 없이 사용될 때 적용됩니다.
//
//사용 예시
//java
//Copy code
//public class Example {
//    
//    @MyAnnotation(value = "Specific value for this method")
//    public void annotatedMethod() {
//        // 메서드 구현
//    }
//    
//    @MyAnnotation  // 기본값 "MyAnnotation : default value" 사용
//    public void anotherMethod() {
//        // 또 다른 메서드 구현
//    }
//}
//위 예시처럼, @MyAnnotation을 메서드 위에 적용하여 해당 메서드에 추가적인 정보나 메타데이터를 제공할 수 있습니다. annotatedMethod 메서드는 value 속성에 "Specific value for this method" 값을 명시적으로 제공하고 있으며, anotherMethod 메서드는 value 속성을 명시적으로 제공하지 않기 때문에 기본값을 사용합니다.
//
//이런 사용자 정의 어노테이션은 프로그램의 로직에 영향을 주지 않으면서, 메타데이터를 제공하거나, 런타임에 특정 처리를 위해 리플렉션을 사용하는 등 다양한 용도로 활용될 수 있습니다.