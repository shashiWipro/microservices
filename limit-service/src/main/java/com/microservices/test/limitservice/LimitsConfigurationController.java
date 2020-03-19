package com.microservices.test.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.test.limitservice.bean.Configuration;
import com.microservices.test.limitservice.bean.LimitsConfiguration;
import com.microservices.test.limitservice.bean.ProductConfiguration;

@RestController
public class LimitsConfigurationController {
   
	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limit")
	public LimitsConfiguration retriveLimitsFromConfiguration()
	{
		return new LimitsConfiguration(configuration.getMinimum(),configuration.getMiximum());
	}
	
	@GetMapping("/success")
	public String sendSuccess()
	{
		
		
		return configuration.getResult();
	}
	
	
	
	@GetMapping("/limit-service/product")
	public ProductConfiguration getProductDetails()
	{
	
		return new ProductConfiguration(configuration.getProductId(),
				configuration.getProductName(), configuration.getProductCategory(),
				configuration.getPrice(),
				configuration.getPort());
	}
	
}
