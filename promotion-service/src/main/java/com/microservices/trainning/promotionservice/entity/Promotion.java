package com.microservices.trainning.promotionservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Promotion")
public class Promotion {
   
	@Id
	private Integer promotionId;
	private String  promoCode;
	private String  productId;
	private String  productCategory;
	private Integer  discountPercentage;
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Promotion(Integer promotionId, String promoCode, String productId, String productCategory,
			Integer discountPercentage) {
		super();
		this.promotionId = promotionId;
		this.promoCode = promoCode;
		this.productId = productId;
		this.productCategory = productCategory;
		this.discountPercentage = discountPercentage;
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
	
	
	
}
