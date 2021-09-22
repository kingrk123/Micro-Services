package in.nit.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.nit.model.Author;

@FeignClient("AUTHOR-SERVICE")
public interface AuthorRestConsumer {

	@GetMapping("/author/one/{id}")
	ResponseEntity<Author> getOneAuthor(
			@PathVariable Integer id);
}
