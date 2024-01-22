package com.example.shop.services;

import com.example.shop.DAO.IProductRepository;
import com.example.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepository productsRepository;

    /** Получить все записи товаров
     * @return список товаров
     */
    public List<Product> getAllProducts() {
        return productsRepository.getAllProducts();
    }

    /** Получить товар по его артикулу
     * @param article артикул товара
     * @return товар
     */
    public Product getProductByArticle(int article){
        return productsRepository.getProductByArticle(article);
    }

    /** Получить список товаров по совпан=дению строки поиска
     * @param pattern  строка поиска
     * @return список товаров
     */
    public List<Product> findProduct(String pattern){
        return productsRepository.findProduct(pattern);
    }

    /** Записать товар в базу
     * @param product товар
     */
    public void saveProduct(Product product){
        productsRepository.saveProduct(product);
    }

    public void delProductByArticle(int article) {
        productsRepository.delProductByArticle(article);
    }
}
