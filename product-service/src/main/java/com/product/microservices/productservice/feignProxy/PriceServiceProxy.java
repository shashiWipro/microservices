package com.product.microservices.productservice.feignProxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.product.microservices.productservice.entity.Product;

//@FeignClient(name = "price-service",url = "localhost:1999")
@FeignClient(name = "price-service")
@RibbonClient(name = "price-service")
public interface PriceServiceProxy {
	 @GetMapping("/price-service/{productId}/{quantities}")
	 public Product findByProductId(@PathVariable("productId") String productId
			                        ,@PathVariable("quantities") Integer quantities);
	
	 
	 
	 @GetMapping("/price-service/prices")
	 public List<Product> findAll();
	 
	 @PostMapping("/price-service/add/{priceId}/{productId}/{price}")
	 public Product addPriceDetails(@PathVariable Integer priceId,@PathVariable String productId,@PathVariable Double price);
	 
	    
}
