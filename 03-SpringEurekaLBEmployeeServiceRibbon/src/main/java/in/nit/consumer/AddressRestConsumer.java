package in.nit.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressRestConsumer {

	@Autowired
	private LoadBalancerClient client;
	
	public String getAddrData() {
		//get one ServiceInstance object using SID
		ServiceInstance  si = client.choose("ADDRESS-SERVICE");
		
		//read URI from SI
		URI uri = si.getUri();
		
		//add path to SI and create URL
		String url = uri + "/address/data";
		
		//Take RestTemplate object
		RestTemplate rt = new RestTemplate();
		
		//make HTTP call
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		
		//return body data
		return response.getBody();
	}

}
