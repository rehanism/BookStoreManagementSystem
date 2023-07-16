package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookListRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookListRepository listrep;
	
	public void save(MyBookList myBook) {
		listrep.save(myBook);
	}
	
	public List<MyBookList> getAllMyBooks()
	{
		return listrep.findAll();
	}
	public void deletebyId(int id)
	{
		listrep.deleteById(id);
	}

}
