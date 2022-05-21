
package com.foodware.foodware.controller;

import com.foodware.foodware.dao.ProductRepository;
import com.foodware.foodware.model.Gategory;
import com.foodware.foodware.model.Product;
import com.foodware.foodware.model.QuantityUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String getNewProductPage(@ModelAttribute Product product, Model model){
        model.addAttribute("gategories", Gategory.values());
        model.addAttribute( "quantityUnits", QuantityUnit.values());
        return "addNewProduct";
    }

    @PostMapping("/newproduct")
    public String addProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model, RedirectAttributes redirAttrs) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("gategories", Gategory.values());
            model.addAttribute( "quantityUnits", QuantityUnit.values());
            return "addNewProduct";
        }

        if(productRepository.findByProductName(product.getProductName()) != null) {
            model.addAttribute("gategories", Gategory.values());
            model.addAttribute( "quantityUnits", QuantityUnit.values());
            model.addAttribute("errorMessage", "Product already exist.");
            return "addNewProduct";
        }

        productRepository.save(product);

        redirAttrs.addFlashAttribute("success", "New product added.");
        return "redirect:/newproduct";
    }

}

