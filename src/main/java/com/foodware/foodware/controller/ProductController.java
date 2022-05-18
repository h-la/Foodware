
package com.foodware.foodware.controller;

import com.foodware.foodware.dao.ProductRepository;
import com.foodware.foodware.model.Gategory;
import com.foodware.foodware.model.Product;
import com.foodware.foodware.model.QuantityUnit;
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

    @GetMapping("/newproduct")
    public String getNewProductPage(Model model){
        model.addAttribute("gategories", Gategory.values());
        model.addAttribute( "quantityUnits", QuantityUnit.values());
        return "addNewProduct";
    }

    @PostMapping("/newproduct")
    public String addProduct(@RequestParam String productName, @RequestParam double quantity, @RequestParam QuantityUnit quantityUnit, Gategory gategory) {
        if (productRepository.findByProductName(productName) != null) {
            return "redirect:/newproduct";
        }

        Product product = new Product(productName, quantity, quantityUnit, gategory);
        productRepository.save(product);
        return "redirect:/newproduct";
    }

}

