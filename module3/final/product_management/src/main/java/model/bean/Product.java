package model.bean;

public class Product {
    private int product_id;
    private String product_name;
    private Double product_price;
    private int product_quantity;
    private String product_color;
    private String product_description;
    private int category_id;
    private String category_name;

    public Product() {
    }

    public Product(String product_name, Double product_price, int product_quantity, String product_color, String product_description, int category_id) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_color = product_color;
        this.product_description = product_description;
        this.category_id = category_id;
    }

    public Product(int product_id, String product_name, Double product_price, int product_quantity, String product_color, String product_description, String category_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_color = product_color;
        this.product_description = product_description;
        this.category_name = category_name;
    }

    public Product(int product_id, String product_name, Double product_price, int product_quantity, String product_color, String product_description, int category_id, String category_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_color = product_color;
        this.product_description = product_description;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
