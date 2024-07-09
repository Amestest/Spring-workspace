package com.khmall.controller;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.util.FileUploadUtil;
/*     기획      ->     백엔드      ->  프론트엔드  
 * 
 * Mapping 작성하고 Mapping("/주소=api")
 * 
 * @Controller
 *   주로 html(view 화면)을 반환하기 위해 사용
 * 
 * @RestController
 *   @Controller와 @ResponseBody 가 합쳐진 형태로 json형택의 객체 데이터를 반환
 *   백엔드 개발자가 보이는 화면(view, html)이 없을 때 
 *   데이터가 무사히 들어오고 나오는지 확인하기 위해 사용하는 컨트롤러
 *   React에 프론트엔드를 작성할 때 사용하기도 함
 * 
 * */
@RequestMapping("api/v2/img") //ImageUploadController 밑에 작성하는 모든 주소 앞에 api/v1/img 붙음
@RestController // -> 백엔드용으로 작성하는 controller
public class ImageUploadController {
	//Request method 'GET' -> 만들어주지
	@GetMapping("/upload") //get api 1개 생성 = api/v2/img/upload
	public String get() {
		return "html 파일 위치를 가르키거나 가르킬 주소";
	}
	
	@PostMapping("/upload")  // post api 1개 생성 = api/v2/img/upload
	public void savImage(@RequestParam("files")MultipartFile[] files) {
		String 업로드할폴더위치 = "imgFolder"; //static 밑에 imgFolder를 만들어서 업로드 시킬 예정
		
		//배열로 이미지를 담아서 한번에 전송
		Arrays.asList(files).stream().forEach(file->{
			//import org.springframework.util.StringUtils;
			
			//파일이름에서 경로를 깔끔하게 정리
			// StringUtils에서 cleanPath 기능 = 파일 이름에 포함될 수 있는 잠재적인 악의적인 값을 제거
			// file에서 가져오기(=get) 원본(=Original) 파일이름(=Filename())
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			System.out.println(fileName);
			
			try {
				// 파일올리기 -> 업로드할 파일위치에 내가원하는 파일이름으로 파일을 올리겠다.
				FileUploadUtil.saveFile(업로드할폴더위치, fileName, file);
				
				
			} catch(Exception e) {
				
			}
		});
		
	}

}