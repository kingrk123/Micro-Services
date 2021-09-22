package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class AppThreeRestController {


	private Logger log = LoggerFactory.getLogger(AppThreeRestController.class);

	@Autowired
	private RestTemplate rt;

	@GetMapping("/showc")
	public String showC() {
		log.info("WELCOME TO SERVICE#3");
		log.info("BYE FROM SERVICE#3:" );
		return "DONE";
	}
}

