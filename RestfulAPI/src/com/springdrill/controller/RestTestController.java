package com.springdrill.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdrill.beans.DataBean1;

@RestController
public class RestTestController {
	
	@GetMapping("/test2")
	public ResponseEntity<ArrayList<DataBean1>> test2() {
		
		DataBean1 bean1 = new DataBean1("문자열1", 100, 11.11, false);
		DataBean1 bean2 = new DataBean1("문자열2", 200, 22.22, true);
		DataBean1 bean3 = new DataBean1("문자열3", 300, 33.33, false);
		
		ArrayList<DataBean1> list  = new ArrayList<DataBean1>();
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		
		
		//응답 결과로 json데이터로 변환하기 위해서 객체로 만들어줘야한다.
		//list: json 데이터를 구성 할 개체를 list에 넣어준다. 
		//HttpStatus.OK:브라우저로 "내가 너한테 보낼 응답결과 가 정상적인 데이터야" 라는걸 알려줌
		ResponseEntity<ArrayList<DataBean1>> entry = new ResponseEntity<ArrayList<DataBean1>>(list, HttpStatus.OK);  
		
		return entry;
	}


	
	
}
