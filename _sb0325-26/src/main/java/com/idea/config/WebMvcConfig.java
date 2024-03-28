package com.idea.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.idea.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addInterceptors(registry);
//		registry.addInterceptor(new LoggerInterceptor());
		
		registry.addInterceptor(new LoggerInterceptor())
		.excludePathPatterns("/css/**","/images/**","/js/**");
	}
	
}
