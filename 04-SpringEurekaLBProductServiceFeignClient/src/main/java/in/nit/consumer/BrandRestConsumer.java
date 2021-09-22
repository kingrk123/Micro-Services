package in.nit.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient( name = "BRAND-SERVICE")
public interface BrandRestConsumer {

	@GetMapping("/brand/data")
	public String getMsg();
}
