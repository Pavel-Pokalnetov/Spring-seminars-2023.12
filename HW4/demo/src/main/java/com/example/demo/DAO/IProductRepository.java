package com.example.demo.DAO;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductRepository {
    List<Product> getAllProducts();
    Product getProductByArticle(int id);

    List<Product> fingProduct(String pattern);

    void saveProduct(Product product);
    void delProductByArticle(int article);
}
