package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Companys;
import com.khmall.mapper.CompanyMapper;

@Service
public class CompanyService {
	@Autowired
	private CompanyMapper companyMapper;
	//회사 정보가 적혀있는 db 내용을 회사목록으로 controller에 전달해주기
	public List<Companys> getAllCompany(){
		return companyMapper.getAllCompany();
	}
}
