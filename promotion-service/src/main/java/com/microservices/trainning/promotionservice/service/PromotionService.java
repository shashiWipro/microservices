package com.microservices.trainning.promotionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.trainning.promotionservice.dao.PromotionDAO;
import com.microservices.trainning.promotionservice.entity.Promotion;

@Service
public class PromotionService {
	
@Autowired	
private PromotionDAO promotionDao;
	
public List<Promotion> findAll()
{
	 List<Promotion> findAll = promotionDao.findAll();
	 return findAll;
}


public List<Promotion> findByProductId(String productId)
{
	List<Promotion> findByProductId = promotionDao.findByProductId(productId);
	return findByProductId;
}



public List<Promotion> findByProductCategory(String productCategory)
{
	List<Promotion> findByProductCategory = promotionDao.findByProductCategory(productCategory);
	return findByProductCategory;
}

public List<Promotion> findByPromoCode(String promoCode)
{
	 List<Promotion> findByPromoCode = promotionDao.findByPromoCode(promoCode);
	 return findByPromoCode;
}

}
