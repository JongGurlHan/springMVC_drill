package com.springdrill.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/save_cookie")
	public String save_cookie(HttpServletResponse response) {
		
		try {
			 String data1 = URLEncoder.encode("문자열1", "UTF-8");
			 String data2 = URLEncoder.encode("문자열2", "UTF-8");
			 
			 Cookie cookie1 = new Cookie("cookie1", data1);
			 Cookie cookie2 = new Cookie("cookie2", data2);
			 
			 cookie1.setMaxAge(365*24*60*60);
			 cookie2.setMaxAge(365*24*60*60);
			 
			  //응답정보를 담을 response에다 쿠키 정보 담는다. 
			 response.addCookie(cookie1);
			 response.addCookie(cookie2);
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "save_cookie";
	}

	@GetMapping("/load_cookie")
	public String load_cookie(HttpServletRequest request) {
		
		//servlet/jsp 에선 모든 쿠키를 가져온 다음 반복문 통해 이름을 가지고 쿠키 확인해야한다. 
		try {
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies) {
				String str = URLDecoder.decode(cookie.getValue(), "UTF-8");
				
				if(cookie.getName().equals("cookie1")) {
					System.out.printf("cooke1 : %s\n", str);
				}else if(cookie.getName().equals("cookie2")) {
					System.out.printf("cooke2 : %s\n", str);
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "load_cookie";
	}
	//스프링 방식은 쿠키정보를 주입받을때 부터 이름을 선별적으로 선택해서 받을 수 있다.(디코딩도 된다)
	@GetMapping("/load_cookie2")
	public String load_cookie2(@CookieValue("cookie1") String cookie1,
							   @CookieValue("cookie2") String cookie2) {
		
		System.out.printf("cookie1 : %s\n", cookie1);
		System.out.printf("cookie2 : %s\n", cookie1);
		
		return "load_cookie2";
	}


	
	
	
}
