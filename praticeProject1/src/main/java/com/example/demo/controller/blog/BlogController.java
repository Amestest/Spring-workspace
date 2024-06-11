package com.example.demo.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blog")
public class BlogController {
	@GetMapping("index")
	public String blogMainMethod() {
		return "blog/blog-index";
	}
	
	//blog-board GetMapping 연결
	@GetMapping("board")
	public String blogBoradMethod() {
		return "blog/blog-board";
	}
}
