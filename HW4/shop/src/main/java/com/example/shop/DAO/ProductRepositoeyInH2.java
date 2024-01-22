package com.example.shop.DAO;

import com.example.shop.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductRepositoeyInH2 implements IProductRepository {
    JdbcTemplate jdbc;

    public ProductRepositoeyInH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * From products";
        return jdbc.query(sql,(resultSet,i) ->{
            Product product = new Product();
            product.setArticle(resultSet.getInt("article"));
            product.setCost(resultSet.getDouble("cost"));
            product.setTitle(resultSet.getString("title"));
            product.setDescription(resultSet.getString("description"));
            product.setImageURL(resultSet.getString("imageURL"));
            return product;
        });
    }

    @Override
    public Product getProductByArticle(int article) {
        String sql = "select * from prodocts where article = ?";
        return jdbc.queryForObject(sql, Product.class,article);
    }

    @Override
    public List<Product> findProduct(String pattern) {
    //todo реализовать поиск по строке
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        String sql = "Insert into products ()";
        //todo реализовать запись в БД
    }

    @Override
    public void delProductByArticle(int article) {
        //todo реализовать удаление из DB по артикулу
    }
}
