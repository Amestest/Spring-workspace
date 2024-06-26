package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Pig;

@Mapper
public interface PigMapper {
	//전체가져오기 -> List
	List<Pig> getAllPigs();
	
	//돼지정보 하나만 가져오기
	Pig getPigsById(int pig_id);
	
	//돼지정보 DB에 업로드하기
	public void uploadPig(Pig pig);
}
