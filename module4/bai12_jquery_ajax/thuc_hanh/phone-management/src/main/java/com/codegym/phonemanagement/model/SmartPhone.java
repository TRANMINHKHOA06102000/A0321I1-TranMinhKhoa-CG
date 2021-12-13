package com.codegym.phonemanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "smartphones")
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String producer;
    private String model;
    private Double price;

    public SmartPhone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return producer + ": " + model + " with price " + price;
    }
}
