package com.example.demo.services;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductsRepository {
    Product product;
    public List<Product> getProducts(){
        Random rnd = new Random();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            product = new Product();
            product.setArticle(i);
            product.setTitle("Товар "+i);
            product.setDescription("Описание товара "+i);
            product.setCost(rnd.nextDouble(1000));
            product.setImageURL("/product.png");
            productList.add(product);
        }
        return productList;
    }

}
