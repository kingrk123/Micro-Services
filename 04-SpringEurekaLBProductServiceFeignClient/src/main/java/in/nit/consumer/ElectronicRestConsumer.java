package in.nit.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.nit.model.Brand;

@FeignClient(name = "ELECTRONICS-SERVICE")
public interface ElectronicRestConsumer {

	@GetMapping("/ele/msg/{code}")
	public String getMsg(
			@PathVariable("code")String code );
	
	@GetMapping("/ele/obj")
	public Brand getObj();
	
	@GetMapping("/ele/list")
	public List<Brand> getList();
	
	@PostMapping("/ele/code")
	public ResponseEntity<String> printCode();
	
	@PostMapping("/ele/save")
	public ResponseEntity<String> saveBrand(
			@RequestBody Brand brand);
	
	
}
