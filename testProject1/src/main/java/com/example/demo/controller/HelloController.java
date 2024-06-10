package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
 @RequestMapping("/test")
 public String testMethod() {
	 System.out.println("/test 요청받았는지확인");
	 return "test";
 }
}
