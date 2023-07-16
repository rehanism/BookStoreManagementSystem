package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;



@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService mbls;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBooks()
	{
		List<Book> list = bookService.getAllBook();

		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Book b)
	{
		bookService.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/book_list")
	public String bookList(Model model)
	{
		List<MyBookList> list =mbls.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book b = bookService.getBookBtId(id);
		MyBookList mb= new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mbls.save(mb);
		return "redirect:/book_list";
	}
	@RequestMapping("/deletebook/{id}")
	public String deletebyId(@PathVariable("id") int id)
	{
		bookService.deleteById(id);
		return "redirect:/available_books";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable ("id") int id,Model model)
	{
		Book b = bookService.getBookBtId(id);
		model.addAttribute("book", b);
		return "updateBook";
	}
	
}
