
package com.foodware.foodware.controller;

import com.foodware.foodware.dao.ProductRepository;
import com.foodware.foodware.model.Gategory;
import com.foodware.foodware.model.Product;
import com.foodware.foodware.model.QuantityUnit;
import com.foodware.foodware.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    @PostMapping("/newproduct")
    public String addProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model, RedirectAttributes redirAttrs) {
        if (productService.checkValidationErrors(product, bindingResult)) {
            if (productService.checkIfProductAlreadyExist(product)) {
                model.addAttribute("errorMessageProductName", "Tuotteen nimi on jo olemassa.");
            }
            if (productService.checkIfQuantityUnitIsEmpty(product)) {
                model.addAttribute("errorMessageQuantityUnit", "Valitse yksikkö.");
            }
            if (productService.checkIfGategoryIsEmpty(product)) {
                model.addAttribute("errorMessageGategory", "Valitse tuotteen kategoria.");
            }
            model.addAttribute("gategories", Gategory.values());
            model.addAttribute( "quantityUnits", QuantityUnit.values());
            return "addNewProduct";
        }

        productRepository.save(product);

        redirAttrs.addFlashAttribute("success", "Tuote lisätty onnistuneesti.");
        return "redirect:/newproduct";
    }

    @GetMapping("/newproduct")
    public String getNewProductPage(@ModelAttribute Product product, Model model){
        model.addAttribute("gategories", Gategory.values());
        model.addAttribute( "quantityUnits", QuantityUnit.values());
        return "addNewProduct";
    }

}

