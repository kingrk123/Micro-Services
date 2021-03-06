package in.nareshit.raghu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/pay")
	public String doPayment() {
		return "SUCCESS=>" + port;
	}
}
