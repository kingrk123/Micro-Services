package in.nit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	

	//it is used to make HTTP calls
	// it creates single object and use with Autowired
	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}
	@Bean
	public Sampler samplerObj() {
		//this makes collecting Ids generated by Sleuth
		return Sampler.ALWAYS_SAMPLE;
		//return Sampler.NEVER_SAMPLE;
		// to stop collecting Ids from sleuth
	}

}
