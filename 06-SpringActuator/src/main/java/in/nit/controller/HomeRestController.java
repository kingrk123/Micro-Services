package in.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeRestController {

	@GetMapping("/show")
	public String showmsg() {
		return "Hello";
	}
}
