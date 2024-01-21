package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log
public class WEBController {
    Product product;
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String indexHtml(Model model){
            model.addAttribute(productService.getAllProducts());
        return "index";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Product product, Model model){
        System.out.println(product);
        productService.saveProduct(product);
        model.addAttribute(productService.getAllProducts());
        return "index";
    }

    @GetMapping("/del/{article}")
    public String delProduct(@PathVariable int article,Model model){
        System.out.println(article);
        productService.delProductByArticle(article);
        model.addAttribute(productService.getAllProducts());
        return "index";
    }

}
