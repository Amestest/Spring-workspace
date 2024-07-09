package com.khmall.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.mapper.ImageUploadMapper;
import com.khmall.util.ImageUploadUtil;

// templates 밑에 html 파일을 만들고 업로드 진행 upload.html 
// -> @Controller (1)     vs   @RestController   (2)

//@RequestMapping("/api/v1/img")
@Controller // html 파일
public class ImageController {
	
	@Autowired 
	private ImageUploadMapper imageUploadMapper;
	/*
	 * @RequestMapping("/api/v1/img")
	 * public class ImageController {
	 * 		@PostMapping("/upload")
	 * 		메서드명
	 * }
	 * */
	@GetMapping("/api/v1/img/upload")   //api 1개 get api = selet나 보여주기 위한 주소 1개
	public String showUploadForm(Model model) {
		return "upload";
	}
	
	
	@PostMapping("/api/v1/img/upload") //api 1개 post api = insert로 값 넣는 주소 1개
	public String insertImageUpload(@RequestParam("files") MultipartFile[] files, 
							Model model) {
		String uploadDir = "imgDir"; //이미지 저장할 폴더명 지정
		Arrays.asList(files).forEach(file -> {
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			//파일네임 무사히 나오는지 확인하고자 한다면 log sysout 사용해서 출력
			//이미지 업로드하는 서비스에 이미지 업로드 할 수 있도록 전달
			try {
				ImageUploadUtil.insertImageUpload(uploadDir, fileName, file);
				
				//데이터베이스에 저장할 정보 설정
				
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("file_name", fileName);
				paramMap.put("upload_dir", uploadDir);
				
				// Mybatis를 사용한 Mapper를 이용해서 DB 삽입
				//The method insertImageUpload(ImageUpload) in the type ImageUploadMapper is not applicable for the arguments (Map<String,Object>)
				//paramMap 의 경우 Map<String, Object> 로 값을 전달해주지만
				//Mapper는 Map<String, Object>로 값을 가져오지 않기 때문에 발생
				imageUploadMapper.insertImageUpload(paramMap);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
		return "index";
	}
}