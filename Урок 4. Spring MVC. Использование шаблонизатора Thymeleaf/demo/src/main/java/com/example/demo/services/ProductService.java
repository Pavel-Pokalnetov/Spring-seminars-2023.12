package com.example.demo.services;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productsRepository;

    public List<Product> getAllProducts() {
        return productsRepository.getProducts();
    }
}
