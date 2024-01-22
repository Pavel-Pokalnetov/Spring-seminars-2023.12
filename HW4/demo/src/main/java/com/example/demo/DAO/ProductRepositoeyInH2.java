package com.example.demo.DAO;

import com.example.demo.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductRepositoeyInH2 implements IProductRepository {
    JdbcTemplate jdbc;

    public ProductRepositoeyInH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * From product;";
        //todo сделать получение из базы
        return null;
    }

    @Override
    public Product getProductByArticle(int id) {
        //todo реализовать
        return null;
    }

    @Override
    public List<Product> fingProduct(String pattern) {
        //todo реализовать
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        //todo реализовать запись в БД
    }

    @Override
    public void delProductByArticle(int article) {
        //todo реализовать удаление из DB по артикулу
    }
}
