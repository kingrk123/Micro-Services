package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private BranchRestConsumer consumer; //HAS-A
	
	@Autowired
	private CompanyRestConsumer Cconsumer;

	@GetMapping("/display")
	public String show() {
		String bm = consumer.communicateWithBranch();
		String cm = Cconsumer.communicateWithCompany();
		return "From DeptService "+bm +cm;
	}

}
