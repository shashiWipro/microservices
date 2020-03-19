package com.microservices.trainning.promotionservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.trainning.promotionservice.entity.Promotion;

@Repository
public interface PromotionDAO extends JpaRepository<Promotion, Integer>{

	public List<Promotion> findByProductId(String productId);
	public List<Promotion> findByProductCategory(String productCategory);
	public List<Promotion> findByPromoCode(String promoCode);
	
}
