package com.microservices.test.limitservice.bean;

public class ProductConfiguration {
	    private String productId;
	    private String productName;
	    private String productCategory;
	    private Double price;
	    private int port;
		public ProductConfiguration() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ProductConfiguration(String productId, String productName, String productCategory, Double price,
				int port) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productCategory = productCategory;
			this.price = price;
			this.port = port;
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
