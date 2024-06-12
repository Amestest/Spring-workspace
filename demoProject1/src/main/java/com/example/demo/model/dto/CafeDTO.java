package com.example.demo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//toString getter setter noArgs AllArgs
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CafeDTO {
	private String cafeCommentName;
	private String cafeCommentOpinion;
}
