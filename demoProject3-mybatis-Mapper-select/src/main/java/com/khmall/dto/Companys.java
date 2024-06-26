package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Companys {
	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone;
	//핸드폰번호는 앞에가 0으로 시작하기 때문에 String으로 작성
	//int는 맨 앞에 붙은 0을 자동으로 없애주기 때문에
	//만약에 01011112222	작성했을 때 String 으로 값을 주면 그래도 들어가지만
	// int로 01011112222 를 작성했을 때 db에 저장되는 값은 1011112222 이다.
}
