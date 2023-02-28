package com.ashu16.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu16.microservice.currencyexchangeservice.beans.CurrencyExchange;
import com.ashu16.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeServiceImpl {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public CurrencyExchange fetchcurrencyExchange(String from , String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
