package com.ashu16.microservice.curreencyconversoinservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashu16.microservice.curreencyconversoinservice.beans.CurrencyConversion;
import com.ashu16.microservice.curreencyconversoinservice.utils.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion caluculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable int quantity) {
		HashMap<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/GBP/to/INR", CurrencyConversion.class, uriVariable);

		CurrencyConversion response = responseEntity.getBody();
		
		return new CurrencyConversion(response.getId(), from, to, 
				response.getConversionMultiple(), quantity, 
				response.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)), response.getEnvironment()+ " "+ "Rest Template");	

	}

	
	@GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion caluculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable int quantity) {
		HashMap<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		CurrencyConversion response = proxy.performCurrencyExchange(from, to);
		
		
		return new CurrencyConversion(response.getId(), from, to, 
				response.getConversionMultiple(), quantity, 
				response.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)), response.getEnvironment() + " "+ "Feign");	

	}
}
