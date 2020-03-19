package com.microservices.trainning.inventoryservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.microservices.trainning.inventoryservice.entity.Inventory;
import com.microservices.trainning.inventoryservice.service.InventoryService;
@RunWith(SpringRunner.class)
@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
private	InventoryService inventoryService;

@Test
public void retriveAll() throws Exception
{
	when(inventoryService.findAll()).thenReturn(
			Arrays.asList(new Inventory("101", "Prod", "Prod", 4, 9999))
			);
	
	RequestBuilder request=MockMvcRequestBuilders
			               .get("/inventory-service/findAll")
			               .accept(MediaType.APPLICATION_JSON);
	
	MvcResult result=mockMvc.perform(request)
			         .andExpect(status().isOk())
			         .andExpect(content().json("[{productId:Prod,productCategory:Prod,quantity:4,port:9999}]",false))
			         .andReturn();

	
}

}
