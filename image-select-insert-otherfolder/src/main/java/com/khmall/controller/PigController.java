package com.khmall.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;

public class PigController {

	@GetMapping("/pig-all-list")
	public String getAllPigs(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		model.addAttribute("pigs", pigs);
		return "돼지모두보는html";
	}
	
	
	@GetMapping("/pig_detail/{pig_id}")
	public String getPigsById(Model model, @PathVariable int pig_id) {
		Pig pig = pigService.getPigsById(Pig_id);
		model.addAttribute("pig",pig);
		return "돼지상세보기html";
		
	}
	
	@GetMapping("/uploadPig")
	public String uploadPig(Model model) {
		model.addAttribute("p", new Pig());
		return "돼지이미지업로스html";
	}
	@PostMapping("/uploadPig")
	public String uploadPig(
			@RequestParam ("pig_name") String pig_name,
			@RequestParam ("pig_age") int pig_age,
			@RequestParam ("pig_image_path") MultipartFile file,
			Model model) {
		
		pigService.uploadPig(pig_name,pig_age,file);
		
		return "redirect:/pig-all-list";
		// 업로드 후 이동하고자 하는 경로
	}
}
