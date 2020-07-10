package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping
	  public String bookIndex(Model model) {
	    List<Book> books = bookService.findAll();
	    model.addAttribute("books", books);
	    return "bookIndex";
	}

	@GetMapping("bookNew")
	public String newbook(Model model) {
		return "bookNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book",book);
		return "bookEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Book book) {
		bookService.save(book);
		return "redirect:/book";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.save(book);
        return "redirect:/book";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/book";
    }
}