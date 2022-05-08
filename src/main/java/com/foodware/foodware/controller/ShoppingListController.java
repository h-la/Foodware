package com.foodware.foodware.controller;

import com.foodware.foodware.dao.AccountRepository;
import com.foodware.foodware.dao.ProductRepository;
import com.foodware.foodware.model.Account;
import com.foodware.foodware.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class ShoppingListController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

    /*@Value("${spring.pass}")
    private String PASS;*/

    @GetMapping("/")
    public String getShoppingList(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    // only for development use
/*
    @GetMapping("/newUser")
    @ResponseBody
    public String make() {
        Account a = new Account();
        a.setUsername("henkka");

        a.setPassword(passwordEncoder.encode(PASS));
        accountRepository.save(a);
        return "Salasana lisätty";
    }
*/

}
