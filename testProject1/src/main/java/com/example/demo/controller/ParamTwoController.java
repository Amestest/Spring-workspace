package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

//@어노테이션 controller RequestMapping Slf4j
@Controller
@RequestMapping("test2")
@Slf4j
public class ParamTwoController {
	//메서드 paramTwoTest
	@PostMapping("test2")
	public String paramTwoTest(@RequestParam("snackName")String snackName,
			@RequestParam("snackCompany")String snackCompany,
			@RequestParam("snackPrice")int snackPrice,
			@RequestParam(value="snackLike",defaultValue="snackLike",required=false)String snackLike
			) {
		log.info(snackName);
		log.info(snackCompany);
		log.info("snackPrice" + snackPrice);
		log.info(snackLike);
		
		return "redirect:/param/main";
	}
	//PostMapping("주소값")
	
	//return /param/param-main
	
	//메서드 paramLikeSnackCompany
	@PostMapping("likeSnackCompany")
	public String paramlikeSnackCompany(@RequestParam(value="likeSnack",required=false)String likeSnack,
			@RequestParam(value="likeSnack",required=false) List<String> likeCompany
			) {
		log.info("좋아하는 과자들 : " + likeSnack);
		log.info("선호하는 회사들 : " + likeCompany);
		
		return"";
	}
}
