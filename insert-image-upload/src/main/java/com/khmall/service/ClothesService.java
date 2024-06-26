package com.khmall.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.mapper.ClothesMapper;

@Service
public class ClothesService {
	
	@Autowired
	private ClothesMapper clothesMapper;
	
	public void uploadClothes(String clothes_name, int clothes_price, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		System.out.println("file Name : " + fileName);
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/insert-image-upload/src/main/resources/static/";
		File imgFile = new File(uploadDir + fileName);
		if(imgFile.exists()) {
			
			imgFile.mkdirs();
		}
	}
}
