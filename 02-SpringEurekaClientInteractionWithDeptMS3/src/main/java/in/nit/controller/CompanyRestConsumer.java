package in.nit.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CompanyRestConsumer {

	@Autowired 
	private DiscoveryClient client;
	
	public String communicateWithCompany() {
		//communicate with Eureka for List<SI> using SID
		List<ServiceInstance> list =client.getInstances("COMPANY-SERVICE");
		
		//choose one SI manually using List index
		ServiceInstance si = list.get(0);
		
		System.out.println(si);
		
		//read URI of SI
		URI uri = si.getUri();
		
		//provide path
		String path = "/company/data";
		
		//------------------//
		
		//Create one URL
		String url = uri + path;
		
		//create RestTemplate object
		RestTemplate rt = new RestTemplate();

		//MAKE Http Request call and get response
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		
		String message = response.getBody();
		
		return message;
	}

	
}
