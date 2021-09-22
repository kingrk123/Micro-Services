package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String bookName;
	private Double bookCost;
	private String bookVersion;
	
	@ManyToOne
	@JoinColumn(name="auth_id_fk")
	private Author auth;//HAS-A
}
