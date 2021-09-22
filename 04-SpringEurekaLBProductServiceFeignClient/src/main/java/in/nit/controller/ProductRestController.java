package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.consumer.BrandRestConsumer;
import in.nit.consumer.ElectronicRestConsumer;
import in.nit.model.Brand;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private BrandRestConsumer consumer;
	
	@Autowired
	private ElectronicRestConsumer consumer1;
	
	@GetMapping("/msg")
	public String getData() {
		return "From Product "+consumer.getMsg();
	}
	
	@GetMapping("/data")
	public String getData1() {
		return "FROM PRODUCT =>" + consumer1.getMsg("NIT-TEST-CODE");
	}
	
	@GetMapping("/one")
	public String getObj() {
		return "FROM PRODUCT:"+consumer1.getObj();
	}
	
	@GetMapping("/all")
	public String getMultiple() {
		return "FROM PRODUCT:"+consumer1.getList();
	}
	
	@PostMapping("/printMsg")
	public String getPrintedMsg() {
		return "FROM PRODUCT=>"+consumer1.printCode();
	}
	
	@PostMapping("/saveobj")
	public String getSaveMsg(
			@RequestBody Brand brand) 
	{
		return "FROM PRODUCT=>"+consumer1.saveBrand(brand);
	}
}
