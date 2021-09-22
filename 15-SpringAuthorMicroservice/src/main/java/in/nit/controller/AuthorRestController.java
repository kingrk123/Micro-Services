package in.nit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Author;
import in.nit.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
	
	private Logger log = LoggerFactory.getLogger(AuthorRestController.class);
	
	@Autowired
	private AuthorService service;
	
	//1. save author
	@PostMapping("/save")
	public ResponseEntity<String> createAuthor(
			@RequestBody Author author)
	{
		log.info("Entered into save operation!");
		ResponseEntity<String> response = null;
		try {
			Integer id = service.saveAuthor(author);
			response = new ResponseEntity<String>(
					"Author '"+id+"' saved",
					HttpStatus.CREATED);
			log.info("Successfully created with id {} ", id);
		} catch (Exception e) {
			log.error("Unable process Author save {} ",e.getMessage());
			e.printStackTrace();
			response = new ResponseEntity<String>(
					"Author unable to save",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("Returning Back to Client Application!");
		return response;
	}
	
	//2. get all records
	@GetMapping("/all")
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> list = service.getAllAuthors();
		return ResponseEntity.ok(list);
	}
	
	//3. get one record
	@GetMapping("/one/{id}")
	public ResponseEntity<Author> getOneAuthor(@PathVariable Integer id)
	{
		Author ob = service.getOneAuthor(id);
		return ResponseEntity.ok(ob);
	}
	
	//4. delete one record
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeAuthor(@PathVariable Integer id)
	{
		service.deleteAuthor(id);
		return ResponseEntity.ok("Author '"+id+"' Removed successfully");
	}
	
	//updated.. TODO
				
	
}
