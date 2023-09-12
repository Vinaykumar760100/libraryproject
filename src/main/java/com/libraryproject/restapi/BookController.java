package com.libraryproject.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.libraryproject.entities.Book;
import com.libraryproject.repo.BookRepo;

@RestController
public class BookController {
	@Autowired
	BookRepo bookrepo;

	// 1
	@GetMapping("/allbooks")
	public List<Book> getall() {
		return bookrepo.findAll();
	}

	// 2
	@GetMapping("/findbybookid/{bookid}")
	public Book getbyid(@PathVariable("bookid") Long bookid) {
		return bookrepo.findById(bookid).get();
	}

	// 3
	@PostMapping("/addnewbook")
	public Book addbook(@RequestBody Book book) {
		bookrepo.save(book);
		return book;
	}

	// 4
	@PutMapping("/nameupdate/{bookid}/{bookname}")
	public Book update(@PathVariable("bookid") Long bookid, @PathVariable("bookname") String bookname) {
		var a = bookrepo.findById(bookid);
		if (a.isPresent()) {
			var b = a.get();
			b.setBookname(bookname);
			bookrepo.save(b);
			return b;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");
		}
	}

	// 5
	@GetMapping("/findbystatus/{status}")
	public List<Book> getbooks(@PathVariable("status") String status) {
		return bookrepo.findbystatus(status);
	}

	@GetMapping("/findname")
	public List<Book> getnames() {
		return bookrepo.findnames();
	}
}
