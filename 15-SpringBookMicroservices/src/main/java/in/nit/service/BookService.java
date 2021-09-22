package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.consumer.AuthorRestConsumer;
import in.nit.exception.BookNotFound;
import in.nit.model.Author;
import in.nit.model.Book;
import in.nit.repo.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private AuthorRestConsumer consumer;

	public Integer saveBook(Book book) {
		Integer authId = book.getAuth().getId();
		Author auth = consumer.getOneAuthor(authId).getBody();
		book.setAuth(auth);
		return repo.save(book).getId();
	}
	
	public Book getOneBook(Integer id) {
		return repo.findById(id).orElseThrow(
				()->new BookNotFound("Book not Found")
				);
	}
	
	public List<Book> getAllBooks(){
		return repo.findAll();
	}
}
