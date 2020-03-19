package com.microservices.test.limitservice.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class Configuration {

	private int minimum;
	private int miximum;
	private String result;
    private String productId;
    private String productName;
    private String productCategory;
    private Double price;
    private int port;
	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Configuration(int minimum, int miximum, String result, String productId, String productName,
			String productCategory, Double price, int port) {
		super();
		this.minimum = minimum;
		this.miximum = miximum;
		this.result = result;
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
		this.port = port;
	}
	
	public Configuration( String productId, String productName,
			String productCategory, Double price, int port) {
		super();
		
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
		this.port = port;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMiximum() {
		return miximum;
	}
	public void setMiximum(int miximum) {
		this.miximum = miximum;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
   
    
}