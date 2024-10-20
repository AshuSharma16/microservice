package com.ashu16.microservice.limitsservice;

import com.ashu16.microservice.limitsservice.beans.UserDeatils;
import com.ashu16.microservice.limitsservice.configuration.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu16.microservice.limitsservice.beans.Limit;
import com.ashu16.microservice.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	@Autowired
	private UserConfiguration userConfiguration;

	@GetMapping("/limits")
	public Limit getLimits() {
		return new Limit(configuration.getMinimum(), configuration.getMaximum());
	}

	@GetMapping("/user")
	public UserDeatils getUserDetails() {
		return new UserDeatils(userConfiguration.getUsername(), userConfiguration.getPw());
	}
}
