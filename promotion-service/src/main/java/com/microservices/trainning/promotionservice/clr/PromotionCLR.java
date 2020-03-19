package com.microservices.trainning.promotionservice.clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservices.trainning.promotionservice.dao.PromotionDAO;
import com.microservices.trainning.promotionservice.entity.Promotion;
@Component
public class PromotionCLR implements CommandLineRunner {
	
@Autowired	
private PromotionDAO promotionDao;
	@Override
	public void run(String... args) throws Exception {
	Promotion pro1=new Promotion(111,"SUPER33", "Prod101", "Electronics", 33);
	Promotion pro2=new Promotion(222,"STAR15",  "Prod202", "Electronics", 15);
	Promotion pro3=new Promotion(333,"DIWALI50", "Prod101", "Electronics", 50);
	Promotion pro4=new Promotion(444,"SUPER33", "Prod101", "faishion", 33);
	promotionDao.save(pro1);
	promotionDao.save(pro2);
	promotionDao.save(pro3);
	promotionDao.save(pro4);
	}

}
