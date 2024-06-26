package com.khmall.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Pig;

@Mapper
public interface PigMapper {
	//1. 돼지정보 전체 리스트 -> List(DTO Pigs)
	List<Pig>getAllPigs();
	//2. 돼지정보 하나만 가져오기 -> DTO Pigs
	Pig getPigsById(int pig_id);
	//3. 돼지정보 DB에 업로드하기 -> void (Pig)
	public void uploadPig(Pig pig);
}
