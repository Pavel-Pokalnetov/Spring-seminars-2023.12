package com.example.demo.DAO;

import com.example.demo.model.Product;
import lombok.NonNull;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Primary
public class ProductsRepositoryInMemmory implements IProductRepository {
    List<Product> productList;

    public ProductsRepositoryInMemmory(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product getProductByArticle(@NonNull int article) {
        return productList.stream()
                .filter(product -> product.getArticle() == article)
                .findFirst().orElse(null);
    }

    @Override
    public List<Product> fingProduct(@NonNull String pattern) {
        return productList.stream()
                .filter(product -> {
                    try {
                        if (product.getTitle().contains(pattern) ||
                                product.getDescription().contains(pattern)) return true;
                        if (product.getArticle() == Integer.parseInt(pattern) ||
                                product.getCost() == Double.parseDouble(pattern)) return true;
                        return false;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }).collect(Collectors.toList());

    }

    /**
     * Запись товара в базу
     *
     * @param product товар
     */
    @Override
    public void saveProduct(@NonNull Product product) {
        productList.add(product);
    }

    @Override
    public void delProductByArticle(int article) {
        //todo реализовать удаление из списка
    }


}
