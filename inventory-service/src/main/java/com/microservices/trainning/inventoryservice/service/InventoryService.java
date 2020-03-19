package com.microservices.trainning.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.trainning.inventoryservice.dao.InventoryDAO;
import com.microservices.trainning.inventoryservice.entity.Inventory;

@Service
public class InventoryService {
     
	@Autowired
	private InventoryDAO inventoryDAO;
	
	public Inventory saveInventoryDetails(@RequestBody Inventory inventory)
	{
		return inventoryDAO.save(inventory);
	}
	
	public Inventory findByProductId(String productId)
	{
		return inventoryDAO.findByProductId(productId);
	}
	
	public List<Inventory> findAll()
	{
		 List<Inventory> findAll = inventoryDAO.findAll();
		 //int port = findAll.get(0).getPort()+100;
		 findAll.get(0).setPort(findAll.get(0).getPort()+100);
		 return findAll;
	}
}
