package com.product.microservices.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.microservices.productservice.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, String> {

}
