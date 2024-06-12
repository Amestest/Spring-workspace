package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

//@어노테이션 Controller RequestMapping Slf4j
@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {

	//@어노테이션 PostMapping(만남의주소)
	//메서드 cafeMainComment
	
	//@어노테이션 RequestParam cafeCommentName cafeCommentOpinion
		//log info로 들어왔는지 확인
		//log debug로 cafeCommentName cafeCommentOpinion 넣기
	//return redirect cafe_index로 돌아가기
	@PostMapping("cafe_index")
	public String cafeMainComment(@RequestParam("cafeCommentName") String cafeCommentName,
								  @RequestParam("cafeCommentOpinion") String cafeCommentOpinion) {
		
		log.info("카페 메인으로 이동하기");
		log.debug("cafeCommentName : " + cafeCommentName);
		log.debug("cafeCommentOpinion : " + cafeCommentOpinion);
		return "redirect:/cafe/cafe_index";
	}
}
