package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.dto.Book;

@Mapper
public interface BookMapper {
	void insertBook(Book book);
}
