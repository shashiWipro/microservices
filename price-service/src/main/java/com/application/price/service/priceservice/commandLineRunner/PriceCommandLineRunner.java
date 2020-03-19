package com.application.price.service.priceservice.commandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.application.price.service.priceservice.dao.PriceDAO;
import com.application.price.service.priceservice.entity.PriceEntity;

@Component
public class PriceCommandLineRunner implements CommandLineRunner{
    
	@Autowired
	private PriceDAO priceDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		savePriceDetails();
	}

public void savePriceDetails()
	{
	PriceEntity price1=new PriceEntity(101, "Prod101", 105d);
	PriceEntity price2=new PriceEntity(102, "Prod102", 145.67);
	PriceEntity price3=new PriceEntity(103, "Prod103", 234.89d);
	PriceEntity price4=new PriceEntity(104, "Prod104", 99.89d);
	PriceEntity price5=new PriceEntity(105, "Prod105", 87.67d);
	PriceEntity price6=new PriceEntity(106, "Prod106", 345.89d);
	priceDao.save(price1);priceDao.save(price2);
	priceDao.save(price3);priceDao.save(price4);
	priceDao.save(price5);priceDao.save(price6);
	}
	
}
