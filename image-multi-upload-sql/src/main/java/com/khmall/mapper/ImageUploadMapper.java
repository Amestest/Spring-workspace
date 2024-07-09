package com.khmall.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import com.khmall.dto.ImageUpload;

@Mapper
public interface ImageUploadMapper {
	//void insertImageUpload(ImageUpload imageUpload);
	/*
	 * Controller에서 paramMap을 Mapper로 전달할 때
	 * imageUploadMapper.insertImageUpload(paramMap);
	 * 
	 * paramMap 맨 앞에
	 * Map<String, Object> paramMap
	 * 
	 * Map과 String Object를 작성해줬기 때문에
	 * Mapper에서도 Map<String, Object>를 붙여줌
	 * 
	 * */
	void insertImageUpload(Map<String, Object> paraMap);
}
