package com.application.price.service.priceservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.price.service.priceservice.dao.PriceDAO;
import com.application.price.service.priceservice.entity.PriceEntity;


@Service
public class PriceService {
	
@Autowired
private PriceDAO priceDao;

public List<PriceEntity> findAll()
{ 
List<PriceEntity> priceList = priceDao.findAll();
return priceList;
}

public PriceEntity findByProductId(String productId,Integer quantities)
{
	PriceEntity priceEntity = priceDao.findByProductId(productId);
	
	if(quantities==null || quantities==1)
	{
		return priceEntity;
	}
	else
	{
		priceEntity.setPrice((priceEntity.getPrice()*quantities));
		return priceEntity;
	}
}

public PriceEntity findByProductIdForUpdate(String productId)
{
	PriceEntity priceEntity = priceDao.findByProductId(productId);
	
	
		return priceEntity;

}

public List<PriceEntity> findPricesBetween(Double value1,Double value2)
{
	List<PriceEntity> findByPriceBetween = priceDao.findByPriceBetween(value1, value2);
	return findByPriceBetween;
}


public List<PriceEntity> findByPriceInAssendingOrder()
{
	List<PriceEntity> findByOrderByPriceAsc = priceDao.findByOrderByPriceAsc();
	return findByOrderByPriceAsc;
}

public List<PriceEntity> findByPriceInDessendingOrder()
{
	List<PriceEntity> findByOrderByPriceDesc = priceDao.findByOrderByPriceDesc();
	return findByOrderByPriceDesc;
}

public String addEntity(PriceEntity priceEntity)
{
	PriceEntity saveEntity = priceDao.save(priceEntity);
	if(null!=saveEntity)
	{
	return "Price Added Successfully";	
	}
    else
	{
		return "did not added Try Again";	
	}
}

public PriceEntity addPriceEntity(PriceEntity priceEntity)
{
	PriceEntity saveEntity = priceDao.save(priceEntity);
	
	return saveEntity;	

   
}


public void deletePricesEntityDetails(Integer priceId)
{
 priceDao.deleteById(priceId);
   
}

public Integer deleteByProductId(String productId) {
	return priceDao.deleteByProductId(productId);
}

}
