package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class clothes {
	private int clothes_id;
	private String clothes_name;
	private int clothes_price;
	private String clothes_category;
	private String clothes_image_path;
}
