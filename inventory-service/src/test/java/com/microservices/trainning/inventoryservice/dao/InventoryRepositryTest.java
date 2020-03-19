package com.microservices.trainning.inventoryservice.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservices.trainning.inventoryservice.entity.Inventory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InventoryRepositryTest{
   
	@Autowired
	private InventoryDAO repository;

	  @Test
	  public void testAll() {
		  repository.save(new Inventory("Inv101", "Prod101", "faishan", 2,0));
		  repository.save(new Inventory("Inv102", "Prod102", "sports", 1,0));
		  repository.save(new Inventory("Inv103", "Prod103", "Electronics", 7,0));
		  repository.save(new Inventory("Inv104", "Prod104", "faishon", 5,0));
		  List<Inventory> findAll = repository.findAll();
	      assertEquals(4, findAll.size()); 
	      assertEquals("Inv101",findAll.get(0).getId());
	      
	  }

	
}
