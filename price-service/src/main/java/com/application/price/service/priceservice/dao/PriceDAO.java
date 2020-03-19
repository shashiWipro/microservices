package com.application.price.service.priceservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.price.service.priceservice.entity.PriceEntity;

@Repository
public interface PriceDAO extends JpaRepository<PriceEntity,Integer>{
	
public PriceEntity findByProductId(String productId);	
public List<PriceEntity> findByPriceBetween(Double value1,Double value2);

public List<PriceEntity> findByOrderByPriceAsc();
public List<PriceEntity> findByOrderByPriceDesc();

public Integer deleteByProductId(String productId);

//Add Price
//Update Price
//Delete Price
	
	
	/* Filtering Operation */
//List All the Prices
//Price By productId and quantity (Default 1 quantity)	
//Price From Lowest To Highest
//Price from Highest to Lowest
//Price Between Ranges
	
}
