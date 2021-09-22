package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private BranchRestConsumer consumer; //HAS-A

	@GetMapping("/data")
	public String getMsg() {
		
		String bm = consumer.communicateWithBranch();
		
		return "FROM COPMANY=> " + bm;
	}
	
	@GetMapping("/sa")
	public String show() {
		return "Hello";
	}
}
