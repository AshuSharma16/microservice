package com.ashu16.microservice.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu16.microservice.currencyexchangeservice.beans.CurrencyExchange;

public interface CurrencyExchangeRepository  extends JpaRepository<CurrencyExchange, Integer>{

	CurrencyExchange findByFromAndTo(String from , String to);
}
