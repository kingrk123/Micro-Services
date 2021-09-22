package in.nit.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class PaymentRestController {

	@GetMapping("/pay")
	@HystrixCommand(fallbackMethod = "doPaymentFallBack")
	public String doPayment() {
		System.out.println("FROM ACTUAL SERVICE");
		if(new Random().nextInt(10)<15) {
			throw new RuntimeException("DUMMY ERROR");
		}
		//calling order MS...
		return "SUCCESS";
	}
	
	public String doPaymentFallBack() {
		System.out.println("FROM FALL BACK METHOD");
		return "FAIL-TRY LATER";
	}
}
