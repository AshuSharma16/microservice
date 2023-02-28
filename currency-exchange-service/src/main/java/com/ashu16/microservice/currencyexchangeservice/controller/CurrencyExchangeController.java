package com.ashu16.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashu16.microservice.currencyexchangeservice.CurrencyExchangeServiceImpl;
import com.ashu16.microservice.currencyexchangeservice.beans.CurrencyExchange;
import com.ashu16.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment; 
	
	@Autowired
	private CurrencyExchangeServiceImpl service;
	
	@GetMapping(path = "/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchange performCurrencyExchange(@PathVariable String fromCurrency,
			@PathVariable String toCurrency) {
		String port = environment.getProperty("local.server.port");
		CurrencyExchange response = service.fetchcurrencyExchange(fromCurrency, toCurrency);
		if(Objects.nonNull(response)) {
			return new CurrencyExchange(response.getId(), response.getFrom(), response.getTo(), response.getConversionMultiple(), port);
		}
		return new CurrencyExchange(1001, fromCurrency, toCurrency, BigDecimal.valueOf(50.0), port);

	}
}
