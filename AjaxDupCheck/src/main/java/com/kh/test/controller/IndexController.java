package com.kh.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	@GetMapping("/")
	public String htmlStart(){
		return "redirect:/index.html";
	}
}
