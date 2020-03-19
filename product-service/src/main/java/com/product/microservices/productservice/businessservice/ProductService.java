package com.product.microservices.productservice.businessservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.microservices.productservice.bean.ProductDetailsResult;
import com.product.microservices.productservice.bean.ProductPricePromotionDetails;
import com.product.microservices.productservice.dao.ProductDao;
import com.product.microservices.productservice.entity.Product;
import com.product.microservices.productservice.feignProxy.InventoryServiceProxy;
import com.product.microservices.productservice.feignProxy.LimitServiceProxy;
import com.product.microservices.productservice.feignProxy.PriceServiceProxy;
import com.product.microservices.productservice.feignProxy.PromotionServiceProxy;

@Service
public class ProductService {

@Autowired
private ProductDao productDao;
	

@Autowired
   private PriceServiceProxy proxy;	

@Autowired
    private InventoryServiceProxy inventoryProxy;

@Autowired
private PromotionServiceProxy promotionProxy;



	public List<Product> findAllProducts()
	{
		return productDao.findAll();
	}
	
	
	
	public Product findProductById(String productId)
	{
		return productDao.findById(productId).get();
	}
	
	
	
	public Product saveProductDetails(Product product)
	{
		 Product resultProduct = productDao.save(product);
		 return  resultProduct;
	}
	
	
	public Product findProductWithPrice(String productId, Integer quantities )
	{
		 Product prodFromProdService=findProductById(productId);
		 Product productDetails = proxy.findByProductId(productId, quantities); 
		 prodFromProdService.setPrice(productDetails.getPrice());
		 
		 prodFromProdService.setPort(productDetails.getPort());
		 //return new Product(productDetails.getProductId(), productDetails.getProductName(), productDetails.getProductCategory(), productDetails.getPrice());
	     return prodFromProdService;
	}

	
	
	@Transactional
public ProductPricePromotionDetails saveCompleateProductDetails(ProductPricePromotionDetails compleateProduct)
    {
	
	//Product prod=new Product("Prod303", "Iron", "Electronics", 1000d);
	Product product = new Product(compleateProduct.getProductId(), compleateProduct.getProductName(),
			compleateProduct.getProductCategory(), compleateProduct.getPrice());
	Product saveProductDetails = saveProductDetails(product);
	
	
	Product addPriceDetails = proxy.addPriceDetails(compleateProduct.getPriceId(), compleateProduct.getProductId(), compleateProduct.getPrice());
	
	ProductPricePromotionDetails saveInventoryDetails =
			  inventoryProxy.saveInventoryData(compleateProduct.getId(),
					                          compleateProduct.getProductId(),
					                          compleateProduct.getProductCategory(),
					                          compleateProduct.getQuantity());
	
	
	ProductPricePromotionDetails resultProd=new ProductPricePromotionDetails(
			saveProductDetails.getProductId(),
			saveProductDetails.getProductName(),
			saveProductDetails.getProductCategory(),
			addPriceDetails.getPrice(),
			addPriceDetails.getPort(), 
			compleateProduct.getPriceId(),
			saveInventoryDetails.getId(),
			saveInventoryDetails.getQuantity());
	
	return resultProd;
    }
	
	
	public List<ProductDetailsResult> findAllPromoCodeOfProduct(String promoCode)
	{
		List<ProductDetailsResult> findByPromoCode = promotionProxy.findByPromoCode(promoCode);
		return findByPromoCode;
	}
	
	
	 public ProductDetailsResult applyPromoCode(String productId,String promoCode)
	 {
		 Product findProductById = findProductWithPrice(productId, 1);
		 List<ProductDetailsResult> findByPromoCode = promotionProxy.findByPromoCode(promoCode);
		 
		 ProductDetailsResult resultProductDetails=new ProductDetailsResult(
				 findByPromoCode.get(0).getPromotionId(),
				 findByPromoCode.get(0).getPromoCode(), 
				 findProductById.getProductId(),
				 findProductById.getProductCategory(),
				 findByPromoCode.get(0).getDiscountPercentage(),
				 findProductById.getProductName(),
				 findByPromoCode.get(0).getPricePort(),
				 findProductById.getPort(),
				 findProductById.getPrice(), 
				 findProductById.getPrice()-((findProductById.getPrice()*findByPromoCode.get(0).getDiscountPercentage())/100), 
				((findProductById.getPrice()*findByPromoCode.get(0).getDiscountPercentage())/100));
		 
		 return resultProductDetails;
	 }
	 
	 

	 
}
