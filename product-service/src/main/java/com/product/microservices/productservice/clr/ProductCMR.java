package com.product.microservices.productservice.clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product.microservices.productservice.dao.ProductDao;
import com.product.microservices.productservice.entity.Product;

@Component
public class ProductCMR implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public void run(String... args) throws Exception {
		productDao.save(new Product("Prod101", "shirt", "faishan",0d));
		productDao.save(new Product("Prod102", "paint", "faishan",0d));
		productDao.save(new Product("Prod103", "tie", "faishan",0d));
		productDao.save(new Product("Prod104", "Iron", "Electronics",0d));
		productDao.save(new Product("Prod105", "phone", "Electronics",0d));
	}

}
