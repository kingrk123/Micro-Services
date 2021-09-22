package in.nit.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Brand;

@RestController
@RequestMapping("/ele")
public class ElectronicsController {

	@GetMapping("/msg/{code}")
	public String getMsg(
			@PathVariable("code")String code )
	{
		return "FROM BRAND=>"+code;
	}
	
	@GetMapping("/obj")
	public Brand getObj() {
		return new Brand(55, "ABC", "NONE");
	}
	
	@GetMapping("/list")
	public List<Brand> getList() {
		return 
				List.of(
						new Brand(30, "ABC", "NONE"),
						new Brand(31, "NIT", "SAMPLE"),
						new Brand(32, "HTC", "NORMAL")
						);
	}	
	
	@PostMapping("/code")
	public ResponseEntity<String> printCode() {
		return new ResponseEntity<>("HELLO",org.springframework.http.HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveBrand(
			@RequestBody Brand brand) {
		return new ResponseEntity<>(brand.toString(),org.springframework.http.HttpStatus
				.OK);
	}
}
