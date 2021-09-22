package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class AppOneRestController {


	private Logger log = LoggerFactory.getLogger(AppOneRestController.class);

	@Autowired
	private RestTemplate rt;

	@GetMapping("/showA")
	public String showA() {
		log.info("WELCOME TO SERVICE#1");
		String msg = rt.getForObject("http://localhost:8082/showB", String.class);
		log.info("BACK TO SERVICE#1:" + msg);
		return "DONE";
	}
}

