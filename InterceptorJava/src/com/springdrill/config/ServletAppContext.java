package com.springdrill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springdrill.interceptor.TestInterceptor1;
import com.springdrill.interceptor.TestInterceptor2;
import com.springdrill.interceptor.TestInterceptor3;
import com.springdrill.interceptor.TestInterceptor4;
import com.springdrill.interceptor.TestInterceptor5;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// Controller 어노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc
// 스캔할 패키지를 지정한다.
@ComponentScan("com.springdrill.controller")
public class ServletAppContext implements WebMvcConfigurer{
	// Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//인터셉터를 등록한다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		
		//인터셉터 객체를 만들고
		TestInterceptor1 inter1 = new TestInterceptor1();
		TestInterceptor2 inter2 = new TestInterceptor2();
		TestInterceptor3 inter3 = new TestInterceptor3();
		TestInterceptor4 inter4 = new TestInterceptor4();
		TestInterceptor5 inter5 = new TestInterceptor5();
		
		//인터셉터 객체를  등록해준다
		InterceptorRegistration reg1 = registry.addInterceptor(inter1);
		InterceptorRegistration reg2 = registry.addInterceptor(inter2);
		InterceptorRegistration reg3 = registry.addInterceptor(inter3);
		InterceptorRegistration reg4 = registry.addInterceptor(inter4);
		InterceptorRegistration reg5 = registry.addInterceptor(inter5);
	
		//주소셋팅
		reg1.addPathPatterns("/test1");
		reg2.addPathPatterns("/test1");
		reg3.addPathPatterns("/test2");
		
		//한개의 인터셉터가 복수개의 요청에 적용된다
//		reg4.addPathPatterns("/test1");
//		reg4.addPathPatterns("/test2");
		
		reg4.addPathPatterns("/test1", "/test2");
		reg4.addPathPatterns("/sub1/test3","/sub1/test4");
	
		//모든 주소를 요청할때 마다 동작하는 인터셉터
	}
}










