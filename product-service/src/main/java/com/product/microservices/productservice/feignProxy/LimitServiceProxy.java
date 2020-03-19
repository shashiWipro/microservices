package com.product.microservices.productservice.feignProxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.product.microservices.productservice.entity.Product;


@FeignClient("limit-service")
@RibbonClient("limit-service")
public interface LimitServiceProxy {
	@GetMapping("/limit-service/product")
	public Product getProductDetails();
	
}
