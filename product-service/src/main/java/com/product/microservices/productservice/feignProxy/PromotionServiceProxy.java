package com.product.microservices.productservice.feignProxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.microservices.productservice.bean.ProductDetailsResult;


@FeignClient("promotion-service")
@RibbonClient("promotion-service")
public interface PromotionServiceProxy {
  
	@GetMapping("/promotion-service/byProdId/{productId}")
	public List<ProductDetailsResult> getPromotionDetailsByProdId(@PathVariable String productId);
	
	@GetMapping("/promotion-service/byProdCategory/{productCategory}")
	public List<ProductDetailsResult> getPromotionDetailsByProdCategory(@PathVariable String productCategory);
	
	

    @GetMapping("/promotion-service/byPromocode/{promoCode}")
    public List<ProductDetailsResult> findByPromoCode(@PathVariable String promoCode);
}
