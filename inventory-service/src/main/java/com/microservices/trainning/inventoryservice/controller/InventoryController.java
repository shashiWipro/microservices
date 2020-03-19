package com.microservices.trainning.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.trainning.inventoryservice.entity.Inventory;
import com.microservices.trainning.inventoryservice.service.InventoryService;

@RestController
public class InventoryController {

@Autowired
private	InventoryService inventoryService;

@Autowired
private Environment env;
	
	@GetMapping("/inventory-service/productId/{productId}")
	public Inventory findByProductId(@PathVariable String productId)
	{
		 Inventory findByProduct = inventoryService.findByProductId(productId);
		// findByProduct.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		 findByProduct.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		 return findByProduct;
	}
	
	
	@GetMapping("/inventory-service/findAll")
	public List<Inventory> findAll()
	{
		 List<Inventory> findByProduct = inventoryService.findAll();
		
		 return findByProduct;
	}
	
	@PutMapping("/inventory-service/updateInventory/{quantity}/{productId}")
	public Inventory saveInventoryDetails(@PathVariable Integer quantity,@PathVariable String productId)
	{
		
		  Inventory inventoryDetails = inventoryService.findByProductId(productId);
		  Integer quantity2 = inventoryDetails.getQuantity();
		  inventoryDetails.setQuantity(quantity2+quantity); 
		  Inventory saveInventoryDetails = inventoryService.saveInventoryDetails(inventoryDetails);
		  saveInventoryDetails.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		  return saveInventoryDetails;
	}
	
	
	@PostMapping("/inventory-service/saveInventory/{id}/{productId}/{productCategory}/{quantity}")
	public Inventory saveInventoryDeta(@PathVariable String id,
			                          @PathVariable String productId,
			                          @PathVariable String productCategory,
		                              @PathVariable Integer quantity
			                           )
	{
		  
		  Inventory saveInventory=new Inventory(id, productId, productCategory, quantity, 0);
		  Inventory saveInventoryDetails = inventoryService.saveInventoryDetails(saveInventory);
		  saveInventoryDetails.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		  return saveInventoryDetails;
	}
	
	
}
