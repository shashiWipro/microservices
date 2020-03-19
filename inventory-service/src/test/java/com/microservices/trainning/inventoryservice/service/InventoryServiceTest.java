package com.microservices.trainning.inventoryservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.microservices.trainning.inventoryservice.dao.InventoryDAO;
import com.microservices.trainning.inventoryservice.entity.Inventory;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {
     @InjectMocks
	private InventoryService inventoryServiceTest;
	
	@Mock
  private InventoryDAO inventoryDAOMock;
	
	
@Test
	public void findAll()
	{
		when(inventoryDAOMock.findAll())
		.thenReturn(Arrays.asList(new Inventory("101", "Prod", "Prod", 4, 9999),
				                  new Inventory("202", "Prod2", "Prod2", 8, 9999)));
		
		List<Inventory> findAll = inventoryServiceTest.findAll();
		assertEquals(9999+100, findAll.get(0).getPort());
		assertEquals("101", findAll.get(0).getId());
		assertEquals("Prod2", findAll.get(1).getProductCategory());
		assertEquals("202", findAll.get(1).getId());
		assertEquals(8, findAll.get(1).getQuantity());
	}
}
