package com.product.microservices.productservice.bean;

public class ProductDetailsResult
{
private Integer promotionId;
private String promoCode;
private String productId;
private String productCategory;
private Integer discountPercentage;
private String productName;
private int pricePort;
private int inventoryPort;
private Double price;
private Double effectivePrice;
private Double savedAmmount;

public ProductDetailsResult() {
	super();
	// TODO Auto-generated constructor stub
}


public ProductDetailsResult(Integer promotionId, String promoCode, String productId, String productCategory,
		Integer discountPercentage, String productName, int pricePort, int inventoryPort, Double price,
		Double effectivePrice, Double savedAmmount) {
	super();
	this.promotionId = promotionId;
	this.promoCode = promoCode;
	this.productId = productId;
	this.productCategory = productCategory;
	this.discountPercentage = discountPercentage;
	this.productName = productName;
	this.pricePort = pricePort;
	this.inventoryPort = inventoryPort;
	this.price = price;
	this.effectivePrice = effectivePrice;
	this.savedAmmount = savedAmmount;
}


public Integer getPromotionId() {
	return promotionId;
}


public void setPromotionId(Integer promotionId) {
	this.promotionId = promotionId;
}


public String getPromoCode() {
	return promoCode;
}


public void setPromoCode(String promoCode) {
	this.promoCode = promoCode;
}


public String getProductId() {
	return productId;
}


public void setProductId(String productId) {
	this.productId = productId;
}


public String getProductCategory() {
	return productCategory;
}


public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}


public Integer getDiscountPercentage() {
	return discountPercentage;
}


public void setDiscountPercentage(Integer discountPercentage) {
	this.discountPercentage = discountPercentage;
}


public String getProductName() {
	return productName;
}


public void setProductName(String productName) {
	this.productName = productName;
}


public int getPricePort() {
	return pricePort;
}


public void setPricePort(int pricePort) {
	this.pricePort = pricePort;
}


public int getInventoryPort() {
	return inventoryPort;
}


public void setInventoryPort(int inventoryPort) {
	this.inventoryPort = inventoryPort;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}


public Double getEffectivePrice() {
	return effectivePrice;
}


public void setEffectivePrice(Double effectivePrice) {
	this.effectivePrice = effectivePrice;
}


public Double getSavedAmmount() {
	return savedAmmount;
}


public void setSavedAmmount(Double savedAmmount) {
	this.savedAmmount = savedAmmount;
}



}
