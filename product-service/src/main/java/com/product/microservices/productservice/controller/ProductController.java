package com.product.microservices.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.product.microservices.productservice.bean.ProductDetails;
import com.product.microservices.productservice.bean.ProductDetailsResult;
import com.product.microservices.productservice.bean.ProductPricePromotionDetails;
import com.product.microservices.productservice.businessservice.ProductService;
import com.product.microservices.productservice.entity.Product;
import com.product.microservices.productservice.feignProxy.InventoryServiceProxy;
import com.product.microservices.productservice.feignProxy.LimitServiceProxy;
import com.product.microservices.productservice.feignProxy.PriceServiceProxy;

@RestController
public class ProductController {
	
@Autowired
private	ProductService productService;

@Autowired
private PriceServiceProxy proxy;	

@Autowired
private InventoryServiceProxy inventoryProxy;

@Autowired
private LimitServiceProxy limitServiceProxy;


@Autowired
private Environment env;

@GetMapping("/product-service/listAll")	
public List<Product> findAllProducts()
	{
		return productService.findAllProducts();
	}



@GetMapping("/product-service/{productId}")	
public Product findProductById(@PathVariable String productId)
{
	return productService.findProductById(productId);
}

	 //Client Side Load Balancer Example Using Ribbon
	 @GetMapping("/product-service/{productId}/{quantities}")	
public Product findProductWithPrice(@PathVariable String productId,@PathVariable Integer quantities )
{
	Product findProductWithPrice = productService.findProductWithPrice(productId, quantities);
	return findProductWithPrice;
}

@GetMapping("/product-service")
public List<Product> findProductsDetailsUsingFeign()
{
	 List<Product> findAll = proxy.findAll();
	 List<Product> products=productService.findAllProducts();
	 for(Product prod:products)
	 {
		for(Product proxyProd:findAll)
		{
			if (prod.getProductId().equals(proxyProd.getProductId())) {
				prod.setPrice(proxyProd.getPrice());
				prod.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			}
		}
	 }
	 
	 return products;
	 
	 
}

@PostMapping("/product-service/saveProduct/{product}")
public ProductDetails saveProductDetails(@RequestBody Product product)
   {
	ProductPricePromotionDetails productFromInventory = inventoryProxy.saveInventoryDetails(1, product.getProductId());
	Product saveProductDetails = productService.saveProductDetails(product);
	return new ProductDetails(saveProductDetails.getProductId(),
			saveProductDetails.getProductName(),
			saveProductDetails.getProductCategory(),
			saveProductDetails.getPort(), productFromInventory.getPort(),
			saveProductDetails.getPrice());
   }



@PostMapping("/product-service/saveProductDetails/{compleateProduct}")
public ProductPricePromotionDetails saveCompleateProductDetails(@RequestBody ProductPricePromotionDetails compleateProduct)
      {
	ProductPricePromotionDetails saveCompleateProductDetails = productService.saveCompleateProductDetails(compleateProduct);
	return saveCompleateProductDetails;
      }

//Hystrix Test
@GetMapping("/product-service_hystrix/{productId}/{quantities}")	
@HystrixCommand(fallbackMethod = "fallbackFindProductWithPrice")
public Product findProductWithPrice_faultTolrance(@PathVariable String productId,@PathVariable Integer quantities )
{
	 Product prodFromProdService=productService.findProductById(productId);

		 
		 Product productDetails = proxy.findByProductId(productId, quantities); 
		 prodFromProdService.setPrice(productDetails.getPrice());
		 
		 prodFromProdService.setPort(productDetails.getPort());


	 //return new Product(productDetails.getProductId(), productDetails.getProductName(), productDetails.getProductCategory(), productDetails.getPrice());
     return prodFromProdService;
}

 public Product fallbackFindProductWithPrice(@PathVariable String productId,@PathVariable Integer quantities)
   {
	return new Product("Prod1001", "HystrixTest", "Cloud", 1000d, 8990);
   }
 
 
 //Hystrix_Test End
 

	/* Promotion Service Test -START*/
 
 //--->find the Product with Price
 
 //--->find The Available Offers
 
 @GetMapping("/product-service/discount/{productId}/{promoCode}")
 public ProductDetailsResult applyPromoCode(@PathVariable String productId,@PathVariable String promoCode)
 {
	 ProductDetailsResult applyPromoCode = productService.applyPromoCode(productId, promoCode);
	 return applyPromoCode;
 }
    /* Promotion Service Test -END*/
 
 
//Hystrix Test with config server
@GetMapping("/product-service_hystrix_config/{productId}/{quantities}")	
@HystrixCommand(fallbackMethod = "fallbackMethodConfigServerTest")
public Product findProductWithPrice_Hystrix_ConfigServer(@PathVariable String productId,@PathVariable Integer quantities )
{
	 Product prodFromProdService=productService.findProductById(productId);

		 
		 Product productDetails = proxy.findByProductId(productId, quantities); 
		 prodFromProdService.setPrice(productDetails.getPrice());
		 
		 prodFromProdService.setPort(productDetails.getPort());


	 //return new Product(productDetails.getProductId(), productDetails.getProductName(), productDetails.getProductCategory(), productDetails.getPrice());
    return prodFromProdService;
}

public Product fallbackMethodConfigServerTest(@PathVariable String productId,@PathVariable Integer quantities)
  {
	Product productDetails = limitServiceProxy.getProductDetails();
	return productDetails;
  }
 
//Hystrix Test with config server
 
 
}
