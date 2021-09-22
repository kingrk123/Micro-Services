package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.exception.AuthorNotFoundException;
import in.nit.model.Author;
import in.nit.repo.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository repo;
	
	public Integer saveAuthor(Author author) {
		return repo.save(author).getId();
	}
	
	public void updateAuthor(Author author) {
		repo.save(author);
	}
	
	public void deleteAuthor(Integer id) {
		Author ob = getOneAuthor(id);
		repo.delete(ob);
	}
	
	public Author getOneAuthor(Integer id) {
		Author ob = repo.findById(id)
				.orElseThrow(()-> new AuthorNotFoundException());
		return ob;
	}
	
	public List<Author> getAllAuthors(){
		return repo.findAll();
	}
}
