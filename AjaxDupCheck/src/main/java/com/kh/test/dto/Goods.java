package com.kh.test.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
	private int item_id;
	private String item_name;
	private String item_description;
}
