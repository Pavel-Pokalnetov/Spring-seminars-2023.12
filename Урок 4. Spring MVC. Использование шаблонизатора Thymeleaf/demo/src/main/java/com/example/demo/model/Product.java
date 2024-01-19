package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class Product {
    private int article;

    private String title;

    private String description;
    private double cost;
    private String imageURL;

    public Product() {
    }

    public Product(int article, String title, String description, double cost, String imageURL) {
        this.article = article;
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.imageURL = imageURL;
    }
    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
