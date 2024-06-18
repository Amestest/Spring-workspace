package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Goods;
import com.example.demo.service.GoodsService;

//class명을 Controller로 작성하면 기존에 Spring에 존재하는 Controller와 충돌이나서 Spring 안에 있는
//Controller 기능을 사용하지 못함
@Controller
public class GoodsController {
	@GetMapping("/")//맨 앞 페이지에서 볼 화면 띄우기
	public String registerForm(Model model) {
		// DB에 값을 넣을 수 있도록 new Goods()를 이용해서 값이 들어갈 공간을 비어서 만들어주기
		model.addAttribute("goods", new Goods());
		return "index";
	}
	
	//GoodsService에 숫자값이 아니면 들억자ㅣ 못하게 방지를 하거나, 비밀번호 암호화설정과 같은 상세기능을 넣고
	//service를 호출해서 mapper java 파일에 값을 전달할 수 있도록 작성해주기
	
	@Autowired
	private GoodsService goodsService;
	
	@PostMapping("/regitser")
	public String insertGoods(Goods goods, Model model) {
		/* Goods goods HTML Form에 name으로 시작하는 변수명이 있으면 
		 * Goods.java의 변수명과 Form에 적은 name값이 일치할 경우
		 * 자동으로 Goods.java라는 곳에 일치하는 변수명에 form에 작성하는 값이 바로바로
		 * db에 들어가기 전에 임시저장(할당됨)
		 * 
		 * Model model= 돌아가기를 하거나, 새로고침과 같은 기능을 사용할 경우, html파링에 데이터를 다시 전달하는 역할
		 * 또 다른의미로 임시저장
		 * */
		goodsService.insertGoods(goods);
		//log
		model.addAttribute("msg","상품이 성공적으로 입력됐습니다.");
		return "registerSuccess";
	}
}
