
package com.foodware.foodware.controller;

import com.foodware.foodware.dao.ProductRepository;
import com.foodware.foodware.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String productName, @RequestParam int number, @RequestParam double quantity, @RequestParam String quantityUnit) {
        if (productRepository.findByProductName(productName) != null) {
            return "redirect:/";
        }

        Product product = new Product(productName, number, quantity, quantityUnit);
        productRepository.save(product);
        return "redirect:/products";
    }

}

