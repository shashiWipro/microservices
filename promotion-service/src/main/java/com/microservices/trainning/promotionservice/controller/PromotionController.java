package com.microservices.trainning.promotionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.trainning.promotionservice.entity.Promotion;
import com.microservices.trainning.promotionservice.service.PromotionService;

@RestController
public class PromotionController {
	@Autowired
private PromotionService promotionService;
	
@GetMapping("/promotion-service/all")	
public List<Promotion> findAll()
	{
	return promotionService.findAll();
	}
	
@GetMapping("/promotion-service/byProdId/{productId}")
public List<Promotion> getPromotionDetailsByProdId(@PathVariable String productId)
{
	List<Promotion> findByProductId = promotionService.findByProductId(productId);
	return findByProductId;
}

@GetMapping("/promotion-service/byProdCategory/{productCategory}")
public List<Promotion> getPromotionDetailsByProdCategory(@PathVariable String productCategory)
{
	List<Promotion> findByProductCategory = promotionService.findByProductCategory(productCategory);
	return findByProductCategory;
}




@GetMapping("/promotion-service/byPromocode/{promoCode}")
public List<Promotion> findByPromoCode(@PathVariable String promoCode)
{
	 List<Promotion> findByPromoCode = promotionService.findByPromoCode(promoCode);
	 return findByPromoCode;
}




}
