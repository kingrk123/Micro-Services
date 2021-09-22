package in.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nit.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
