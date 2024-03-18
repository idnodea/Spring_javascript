package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration   //콘피귤레이션추가
@EnableWebMvc    //스프링 추가
public class MvcConfig implements WebMvcConfigurer{

	//소스-임플리먼트 메서드 (아래에 두개추가
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		configurer.enable();
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.configureViewResolvers(registry);
		
		registry.jsp("/WEB-INF/view/",".jsp");  //폴더명을 똑같이 써주어야함(대문자이므로 대문자)
	}     

}  //여기 세팅까진 거의 고정

//<project>: Maven 프로젝트의 최상위 요소입니다.
//
//xmlns: XML 네임스페이스를 지정합니다.
//xmlns:xsi: XML Schema 인스턴스 네임스페이스를 지정합니다.
//xsi:schemaLocation: XML 스키마 위치를 지정합니다.
//<modelVersion>: Maven 모델의 버전을 지정합니다. 현재 사용 중인 Maven 버전을 나타냅니다.
//
//<groupId>: 프로젝트의 그룹 아이디를 지정합니다. 일반적으로 회사 도메인을 역순으로 사용합니다.
//
//<artifactId>: 프로젝트의 아티팩트 아이디를 지정합니다. 이것은 프로젝트의 고유한 식별자입니다.
//
//<version>: 프로젝트의 버전을 지정합니다.
//
//<packaging>: 프로젝트가 어떤 형태로 패키징되는지를 지정합니다. 예를 들어, war는 웹 애플리케이션으로 패키징됨을 나타냅니다.
//
//<dependencies>: 프로젝트가 의존하는 외부 라이브러리들을 지정합니다.
//
//<dependency>: 프로젝트가 의존하는 개별 라이브러리를 지정합니다.
//
//<groupId>: 의존하는 라이브러리의 그룹 아이디를 지정합니다.
//<artifactId>: 의존하는 라이브러리의 아티팩트 아이디를 지정합니다.
//<version>: 의존하는 라이브러리의 버전을 지정합니다.
//<scope>: 의존하는 라이브러리의 사용 범위를 지정합니다.
//예를 들어, provided는 컴파일 시에는 사용되지만 실행 시에는 제외됩니다.
//<build>: 프로젝트의 빌드 설정을 지정합니다.
//
//<plugins>: 빌드 중에 사용되는 플러그인들을 지정합니다.
//
//<artifactId>maven-compiler-plugin</artifactId>: Maven 컴파일 플러그인을 사용합니다.
//
//<configuration>: 플러그인의 구성 설정을 지정합니다.
//<source>: 컴파일할 소스 코드의 자바 버전을 지정합니다.
//<target>: 컴파일된 바이트 코드의 대상 JVM 버전을 지정합니다.
//<encoding>: 소스 코드의 인코딩을 지정합니다.
//이러한 XML 형식은 Maven의 관례에 따라 정의되었으며,
//Maven은 이러한 정보를 사용하여 프로젝트를 빌드하고 종속성을 관리합니다.
//
//registry.jsp("/WEB-INF/view/",".jsp")에서 쉼표는 registry 메서드의 인자로 
//두 개의 값("/WEB-INF/view/"와 ".jsp")을 전달하는 데 사용됩니다. 
//이 경우, 첫 번째 매개변수는 뷰 파일이 저장된 경로이고
//두 번째 매개변수는 뷰 파일의 확장자입니다. 
//이렇게 함으로써 Spring MVC가 정상적으로 뷰를 찾을 수 있습니다.
