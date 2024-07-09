package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsItemService;

@RestController
public class GoodsItemController {
	
	@Autowired
	private GoodsItemService goodsItemService;
	// 만약에 에러로 template[check] @Controller -> @RestController
	@GetMapping("/gooditem/check")//ajax에서 url에 작성한 url값 넣어주기
	public Map<String, Object> existsByName(@RequestParam String itemName) {
		//만약에 상품명이 조회가 된다면 이미 존재하는 상품명입니다. 만들기
		
		boolean isCheck = goodsItemService.existsByName(itemName);
		Map<String, Object> res = new HashMap<>();
		// String itemName  Object isCheck
		//ajax는 html을 return 작성하지 않음
		// 왜냐하면 html 파일을 불러오는 것이 아니라
		// html 파일의 일부분만 설정하는 것이기 때문
		res.put("isCheck", isCheck);
		
		return res; //Map으로 전달된 key value를 다시 html 파일에서 중복체크에 전달
	}

}