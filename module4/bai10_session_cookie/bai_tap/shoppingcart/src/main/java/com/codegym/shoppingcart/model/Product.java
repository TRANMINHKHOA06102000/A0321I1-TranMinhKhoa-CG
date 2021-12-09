package com.codegym.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private String imageUrl;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Product){
            Product anotherItem = (Product) object;
            if (this.id == anotherItem.id){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.id;
    }
}
