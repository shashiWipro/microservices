package com.application.price.service.priceservice.controller;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.price.service.priceservice.entity.PriceEntity;
import com.application.price.service.priceservice.services.PriceService;



@RestController
public class PriceServiceController {
	@Autowired
	private PriceService priceService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private Environment environment;
	
	/* Create */
//Add Price                                            -->Done
	
	/* Update */
//Update Price                                         -->Done
	
	
	/* Retrieve Operation */
//List All the Prices                                   -->Done
//Price By productId and quantity (Default 1 quantity)	-->Done
//Price From Lowest To Highest                          -->Done
//Price from Highest to Lowest                          -->Done
//Price Between Ranges                                  -->Done 

	/* Delete */
//Delete Price                                          -->Done
@PostMapping("/price-service/add/{priceEntity}")
public String addPrice(@RequestBody PriceEntity priceEntity)
{
String addEntity = priceService.addEntity(priceEntity);
	return addEntity;
}
	
@PostMapping("/price-service/add/{priceId}/{productId}/{price}")
public PriceEntity addPriceDetails(@PathVariable Integer priceId,@PathVariable String productId,@PathVariable Double price)
{
	PriceEntity priceEntity=new PriceEntity(priceId, productId, price);
	PriceEntity addPriceEntity = priceService.addPriceEntity(priceEntity);
	return addPriceEntity;
}
	

@GetMapping("/price-service/prices")
public List<PriceEntity> findAll()
   {
		List<PriceEntity> priceList = priceService.findAll();
		return priceList;
	}
	
	@GetMapping("/price-service/{productId}/{quantities}")
 public PriceEntity findByProductId(@PathVariable String productId,@PathVariable Integer quantities)
 {	
	PriceEntity findByProductId = priceService.findByProductId(productId, quantities);
	findByProductId.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	return findByProductId;
 }
	
	@GetMapping("/price-service/between/{value1}/{value2}")
public List<PriceEntity> findPriceBetween(@PathVariable Integer value1,@PathVariable Integer value2)
{
	return priceService.findPricesBetween(new Double(value1), new Double(value2));
}

	
	@GetMapping("/price-service/mintomax")	
public List<PriceEntity> searchLowestPriceToHighestPrice()
{
	List<PriceEntity> findByPriceInAssendingOrder = priceService.findByPriceInAssendingOrder();
	return findByPriceInAssendingOrder;
	
}

	@GetMapping("/price-service/maxtomin")	
public List<PriceEntity> searchHighestPriceToLowestPrice()
{
	List<PriceEntity> findByPriceInAssendingOrder = priceService.findByPriceInDessendingOrder();
	return findByPriceInAssendingOrder;
	
}


	@PutMapping("/price-service/update/{productId}")
	public ResponseEntity<PriceEntity> updatePriceDetails(@RequestBody PriceEntity updatePrice, @PathVariable String productId) {
	
	PriceEntity priceEntity=priceService.findByProductIdForUpdate(productId);

		if (priceEntity==null)
			return ResponseEntity.notFound().build();

		priceEntity.setProductId(productId);
		priceEntity.setPrice(updatePrice.getPrice());
		priceService.addEntity(priceEntity);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/price-service/delete/{priceId}")
	public void deletePriceEntity(@PathVariable Integer priceId)
	{
		priceService.deletePricesEntityDetails(priceId);
	}
	
	@DeleteMapping("/price-service/deleteByProdId/{priceId}")
	public Integer deleteByProductId(String productId) {
		return priceService.deleteByProductId(productId);
	}
	

@RequestMapping("/price-service/convert/{price}/{currency}")	
 private String convertToOtherCurrency(@PathVariable Double price,@PathVariable String currency) throws JSONException
     {
	  double productList = convertFromINRToOtherCurrency(price,currency);
	  String valueOf = String.valueOf(productList);
	  return valueOf+" "+currency;
     }

public double convertFromINRToOtherCurrency(Double price ,String currency) throws JSONException {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	       String body = restTemplate.exchange("https://api.exchangerate-api.com/v4/latest/INR", 
	    		                               HttpMethod.GET, entity, String.class).getBody();
        
	       JSONObject jsonObject = new JSONObject(body);
	      
	       
	       //String age = jsonObject.getString("base");
	       //System.out.println(age);
	       
	       
	       String rates = jsonObject.getString("rates");
	       System.out.println(rates);
	       
	       
	       jsonObject=new JSONObject(rates);
	       String DOP=jsonObject.getString(currency);
	       System.out.println("DOP\t"+DOP);
	       double parseDouble = Double.parseDouble(DOP);
	       return (parseDouble*price);
	   }
	
	
}
