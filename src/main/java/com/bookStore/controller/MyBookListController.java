package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.service.MyBookListService;

@Controller
public class MyBookListController {

	@Autowired
	private MyBookListService mbls;
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		mbls.deletebyId(id);
		return "redirect:/book_list";
	}
}
