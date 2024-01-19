package com.example.demo.controller;

import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WEBController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String indexHtml(Model model){
            model.addAttribute(productService.getAllProducts());
        return "index";
    }
}
