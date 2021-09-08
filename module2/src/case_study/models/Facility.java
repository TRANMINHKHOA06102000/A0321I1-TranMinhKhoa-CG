package case_study.models;

import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String id;
    private String name;
    private int area;
    private double price;
    private int amount;
    private String typeRents;

    public Facility() {
    }

    public Facility(String id,String name, int area, double price, int amount, String typeRents) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.amount = amount;
        this.typeRents = typeRents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypeRents() {
        return typeRents;
    }

    public void setTypeRents(String typeRents) {
        this.typeRents = typeRents;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", amount=" + amount +
                ", typeRents='" + typeRents + '\'' +
                '}';
    }
}
