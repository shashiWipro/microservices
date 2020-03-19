package com.microservices.trainning.inventoryservice.commandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservices.trainning.inventoryservice.dao.InventoryDAO;
import com.microservices.trainning.inventoryservice.entity.Inventory;

@Component
public class InventoryCommandLineRunner  implements CommandLineRunner{
    
	@Autowired
	private InventoryDAO inventoryDAO;
	
	@Override
	public void run(String... args) throws Exception {
	
		inventoryDAO.save(new Inventory("Inv101", "Prod101", "faishan", 2,0));
		inventoryDAO.save(new Inventory("Inv102", "Prod102", "sports", 1,0));
		inventoryDAO.save(new Inventory("Inv103", "Prod103", "Electronics", 7,0));
		inventoryDAO.save(new Inventory("Inv104", "Prod104", "faishon", 5,0));
	}

}
