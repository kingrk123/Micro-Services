package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Author {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String address;
	private String email;
	
}