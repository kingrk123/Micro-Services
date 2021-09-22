package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.nit.bean.ExchangeValue;
import in.nit.repo.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment enviroment;

	@Autowired
	private CurrencyExchangeRepository repo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from,@PathVariable String to ) {
		// ExchangeValue exchangeValue= new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65) );
		
		logger.info("retrieveExchangeValue called with {} to {}", from, to);
		
		ExchangeValue exchangeValue =repo.findByFromAndTo(from, to);
		if(exchangeValue == null)
			throw new RuntimeException("Unable to find data for "+from+"to"+to);
		exchangeValue.setPort(Integer.parseInt(enviroment.getProperty("local.server.port")));

		return exchangeValue;
	}
}
