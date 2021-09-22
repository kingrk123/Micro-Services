package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.consumer.AddressRestConsumer;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private AddressRestConsumer consumer;

	@GetMapping("/info")
	public String showEmp() {
		return "FROM-EMP=>" + consumer.getAddrData();
	}
}
