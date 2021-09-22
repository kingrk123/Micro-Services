package in.nit.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.nit.bean.CurrencyConversion;

//@FeignClient(name ="Currency-exchange-service", url = "localhost:8000" )
@FeignClient(name ="Currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(@PathVariable String from,@PathVariable String to ) ;
}
