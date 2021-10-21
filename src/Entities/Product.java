/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author bissa
 */
public class Product {
    private int id ;
    private String category;
    private String product;
    private int stock;
    private float price;
    private int rating;

    public Product() {
    }

    public Product(String category, String product, int stock, float price, int rating) {
       
        this.category = category;
        this.product = product;
        this.stock = stock;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String category, String product, int stock, float price, int rating) {
        this.id = id;
        this.category = category;
        this.product = product;
        this.stock = stock;
        this.price = price;
        this.rating = rating;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", category=" + category + ", product=" + product + ", stock=" + stock + ", price=" + price + ", rating=" + rating + '}';
    }
    
}

    
    

   