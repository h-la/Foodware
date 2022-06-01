package com.foodware.foodware.services;

import com.foodware.foodware.dao.ProductRepository;
import com.foodware.foodware.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public boolean checkIfProductAlreadyExist(Product product) {
        if (product.getProductName().isEmpty()) {
            return false;
        }
        return productRepository.findByProductName(product.getProductName()) != null;
    }

    public boolean checkIfQuantityUnitIsEmpty(Product product) {
        if (product.getQuantityUnit() == null) {
            return true;
        }
        return false;
    }

    public boolean checkIfGategoryIsEmpty(Product product) {
        if (product.getGategory() == null) {
            return true;
        }
        return false;
    }

    public boolean checkValidationErrors(Product product, BindingResult bindingResult) {
        if (this.checkIfProductAlreadyExist(product) || this.checkIfQuantityUnitIsEmpty(product) || checkIfGategoryIsEmpty(product)) {
            return true;
        }
        return bindingResult.hasErrors();
    }

}
