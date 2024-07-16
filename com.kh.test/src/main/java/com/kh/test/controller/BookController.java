package com.kh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.dto.Book;
import com.kh.test.service.BookService;

@RequestMapping("/books")
@Controller
public class BookController {
	@Autowired
	 private BookService bookService;
	    @GetMapping("/add")
	    public String showAddBookForm(Model model) {
	        model.addAttribute("book", new Book());
	        return "book";
	    }
	  @PostMapping("/add")
	    public String insertBook(Book book) {
	        bookService.insertBook(book);
	        return "redirect:/books/add";
	    }
}
