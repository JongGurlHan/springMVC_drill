package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {

	@PostMapping("/test1")
//	public String test1(@ModelAttribute DataBean bean) { 
	public String test1(DataBean bean) { //@ModelAttribute은 생략가능 
//		System.out.printf("data1 : %s\n" ,bean.getData1());
//		System.out.printf("data2 : %s\n" ,bean.getData2());
		
		return "test1";
	}
	//request 영역에 저정되는 이름을 직접 지정하겠다.
	//만약 이름(testData)을 정해주지 않으면  앞글자를 소문자로 해서 클래스 타입과 동일한 이름d(dataBean)
	//으로 request 영역에 담기게 된다. 
	@PostMapping("/test2")
	public String test2(@ModelAttribute("testData") DataBean bean ) {
		return "test2";
	}
	
}
