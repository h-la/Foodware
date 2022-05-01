package com.foodware.foodware.dao;

import com.foodware.foodware.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);
}
