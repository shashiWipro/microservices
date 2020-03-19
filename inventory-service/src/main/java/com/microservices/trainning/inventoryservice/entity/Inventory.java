package com.microservices.trainning.inventoryservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Inventory" )
public class Inventory {

	@Id
private String  id;
private String  productId;
private String  productCategory;
private Integer quantity;

private int port;

public Inventory() {
	super();
	
}


public Inventory(String id, String productId, String productCategory, Integer quantity,int port) {
	super();
	this.id = id;
	this.productId = productId;
	this.productCategory = productCategory;
	this.quantity = quantity;
	this.port=port;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
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


public Integer getQuantity() {
	return quantity;
}


public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}


public int getPort() {
	return port;
}


public void setPort(int port) {
	this.port = port;
}
	

}
