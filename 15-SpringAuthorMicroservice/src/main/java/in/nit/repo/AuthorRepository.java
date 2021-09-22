package in.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nit.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
