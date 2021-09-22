package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class AppTWORestController {


	private Logger log = LoggerFactory.getLogger(AppTWORestController.class);

	@Autowired
	private RestTemplate rt;

	@GetMapping("/showB")
	public String showB() {
		log.info("WELCOME TO SERVICE#2");
		String msg = rt.getForObject("http://localhost:8083/showC", String.class);
		log.info("BACK TO SERVICE#2:" + msg);
		return "DONE";
	}
}

