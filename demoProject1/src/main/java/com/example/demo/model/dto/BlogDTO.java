package com.example.demo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@어노테이션 이용해서 construct, getter, setter, toString
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BlogDTO {
	private String commentName;
	private String commentOpinion;
}
