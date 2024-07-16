package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.Book;
import com.kh.test.mapper.BookMapper;

@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;

	public void insertBook(Book book) {
		bookMapper.insertBook(book);

	}
}
