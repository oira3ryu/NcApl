package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class BookService {

	@Autowired
	BookRepository repository;

	public List<Book> findAll() {
		return repository.findAll();
	}

	public Book findOne(Integer id) {
		Optional<Book> book = repository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}

	public Book save(Book book) {
		return repository.save(book);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
