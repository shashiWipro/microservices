package com.microservices.trainning.inventoryservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.trainning.inventoryservice.entity.Inventory;

@Repository
public interface InventoryDAO  extends JpaRepository<Inventory, String>{

public Inventory findByProductId(String productId);
	
}
