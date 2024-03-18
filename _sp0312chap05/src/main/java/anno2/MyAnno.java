package anno2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//p136 애노테이션박스만들기
@Target(ElementType.METHOD)
//적용대상은 method입니다
@Retention(RetentionPolicy.RUNTIME)
//유지정책은 runtime입니다 컴파일이후에도 jvm이 참조합니다
public @interface MyAnno {
	//String타입으로 사용가능합니다
	public String value();
	
	
}
