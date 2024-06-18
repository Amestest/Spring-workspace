package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*lombok활용한 Getter Setter 기초생성자 필수생성자 toString만들기*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private int goodsQuantity;
}
