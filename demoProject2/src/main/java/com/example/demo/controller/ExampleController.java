package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller // 요청하거나 응답제어 역할을 명시 Bean 등록 Bean = Spring에서 어떤 기능을 하라 설정해놓은 값
@RequestMapping("example") // example로 시작하는 주소를 해당 컨트롤러에 넣어줌
@Slf4j //lombok 라이브러리가 제공하는 로그 객체 자동생성 어노테이션
public class ExampleController {
	/*
	 Model
	  - Spring 에서 데이터 전달 역할을 하느 ㄴ객체
	  - org.springframework.ui 패키지
	  - @SessionAttributes와 함게 사용할 경우 session scope 반환
	  [기본 사용법]
	  Model.addAttribute("key","value");
	    */
	@GetMapping("ex1") //  /exmaple/ex1 주소로 보여지는 값
	public String ex1(HttpServletRequest req, Model model) {
		
		// 나중에 db에서 가져온 값ㅇ르 보여줄 때 사용하는 메서드
		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2","Model로 전달할 값");
		return "exmaple/ex1"; //templates/example/ex1.html 파일 바라보는것
	}
}
