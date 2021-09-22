package in.nit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.bean.ExchangeValue;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Serializable> {

	ExchangeValue findByFromAndTo(String from, String to);
}
