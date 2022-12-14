package com.book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookEntity;
import com.book.repository.BookRepository;

@Service
public class BookService {
@Autowired
BookRepository bookRepository;

	public Iterable<BookEntity> getBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public BookEntity postBook(BookEntity book) {
		// TODO Auto-generated method stub
		 bookRepository.save(book);
		 return book;
	}

	public Optional<BookEntity> getBookbyid(Integer id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
		
	}

}
