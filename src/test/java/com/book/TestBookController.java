package com.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.controller.BookController;
import com.book.entity.BookEntity;
import com.book.service.BookService;

@ExtendWith(MockitoExtension.class)
public class TestBookController {
@Mock
BookService bookService;
@InjectMocks
BookController bookController;

@Test
public void testgetBooks() throws Exception {
	List<BookEntity> books=new ArrayList<>();
	BookEntity book=new BookEntity();
	book.setAuthor("mahesh");
	book.setCategory("coding");
	book.setDate("2022/10/23");
	book.setId(5);
	book.setPrice(100);
	book.setPublisher("sapna");
	book.setTitle("java");
	books.add(book);
	Mockito.when(bookService.getBooks()).thenReturn(books);
	Iterable<BookEntity>getbooks=bookController.getBooks();
	assertEquals(books, getbooks);
	}

@Test
public void testPostBook() {
	BookEntity book=new BookEntity();
	book.setAuthor("mahesh");
	book.setCategory("coding");
	book.setDate("2022/10/23");
	book.setId(5);
	book.setPrice(100);
	book.setPublisher("sapna");
	book.setTitle("java");
	Mockito.when(bookService.postBook(book)).thenReturn(book);
	Integer postbookId=bookController.postBook(book);
	assertEquals(5, postbookId);
	}
@Test
public void testgetBookbyid() throws Exception{
	Optional<BookEntity> book= Optional.of(new BookEntity());
	Mockito.when(bookService.getBookbyid(5)).thenReturn(book);
	Optional<BookEntity> Bookbyid= bookController.getBookbyid(5);
	assertEquals(book, Bookbyid);
}

}
