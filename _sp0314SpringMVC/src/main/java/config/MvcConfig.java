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
