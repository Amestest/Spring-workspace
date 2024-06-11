package com.example.demo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Getter와 Setter 는 Lombok 라이브러리 활용해서
 * 길게 작성하지 않음
 * 기본생성자 
 * 
 * */
@Getter
@Setter
@NoArgsConstructor //기초생성자
@ToString
public class MemberDTD {
	// 나중에 db랑 연결할 모델들 작성
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
//메서드
	//Getter -> lombok @Getter 자동완성 사용하기
	//Setter -> lombok @Setter 자동완성 사용하기
	//기본생성자 -> lombok @NoArgsConstructor 자동완성 사용하기
	//필수생성자 -> lombok @AllArgsConstructor 자동완성 사용하기
	//toString -> lombok @ToString 자동완성 사용하기
}
