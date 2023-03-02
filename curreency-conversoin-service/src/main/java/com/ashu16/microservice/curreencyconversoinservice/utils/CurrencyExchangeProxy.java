package com.ashu16.microservice.curreencyconversoinservice.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashu16.microservice.curreencyconversoinservice.beans.CurrencyConversion;

//@FeignClient(name="curreency-exchnage-service" , url="localhost:8000")
@FeignClient(name="curreency-exchnage-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping(path = "/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversion performCurrencyExchange(@PathVariable String fromCurrency,
			@PathVariable String toCurrency);
		

}
