package com.example.demo.controller;
//8085 에서 실행
//->Slf4j 추가해주고 log.info 접속확인 log.debug 만들어주기
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param") //ParameterController 밑에는 모두 자동으로 맨 앞에 param 붙음
@Slf4j
public class ParameterController {
	
	@GetMapping("main")
	public String paramMain() {
		return "param/param-main"; //폴더 param 안에 있는 param-main.html 파일 바라보기
	}
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));//-->String 에서 int로 형변환
				
		log.info("시작했는지 확인");
		log.info("이름확인 : " + inputName);
		log.info("나이확인 : " + inputAge);
		log.info("주소확인 : " + inputAddress);
		
		log.info("=========================");
		log.debug("이름확인 : " + inputName);
		log.debug("나이확인 : " + inputAge);
		log.debug("주소확인 : " + inputAddress);
		return "redirect:/param/main"; // 작성 다 되면 메인으로 돌아가기
	}
}
