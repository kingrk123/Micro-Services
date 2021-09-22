package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.bean.LimitsConfiguration;
import in.nit.config.Configuration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitsConfiguration retriveLimitsConfiguration() {
		return new LimitsConfiguration(config.getMaximum(),config.getMinimum());
	}
}
