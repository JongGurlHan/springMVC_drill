package com.springdrill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasicController {
	
	@GetMapping("/test1")
	public String test1() {
		
		return "test1";
	}

	


	
	
	
}
