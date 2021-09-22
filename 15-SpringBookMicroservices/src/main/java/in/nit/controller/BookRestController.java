package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Book;
import in.nit.service.BookService;

@RestController
@RequestMapping("/book")
public class BookRestController {
	@Autowired
	private BookService service;
	
	//1. save book
	@PostMapping("/save")
	public ResponseEntity<String> saveBook(
			@RequestBody Book book
			)
	{
		Integer id = service.saveBook(book);
		return ResponseEntity.ok("saved with id:" + id); 
	}
	
	//2. get one book by id
	@GetMapping("/one/{id}")
	public ResponseEntity<Book> getOneBook(
			@PathVariable Integer id) 
	{
		Book book = service.getOneBook(id);
		return ResponseEntity.ok(book);
	}
	//3. get all books
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list = service.getAllBooks();
		return ResponseEntity.ok(list);
	}
	
}
