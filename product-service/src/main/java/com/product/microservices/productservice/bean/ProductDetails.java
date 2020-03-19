package com.product.microservices.productservice.bean;

public class ProductDetails
{
private String productId;
private String productName;
private String productCategory;
private int pricePort;
private int inventoryPort;
private Double price;
public ProductDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public ProductDetails(String productId, String productName, String productCategory, int pricePort, int inventoryPort,
		Double price) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productCategory = productCategory;
	this.pricePort = pricePort;
	this.inventoryPort = inventoryPort;
	this.price = price;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
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


}
