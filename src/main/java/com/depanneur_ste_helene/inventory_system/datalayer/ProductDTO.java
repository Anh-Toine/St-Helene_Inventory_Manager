package com.depanneur_ste_helene.inventory_system.datalayer;


public class ProductDTO {
    private Integer productId;
    private Integer bar_code;
    private String product_name;
    private String brand;
    private double price;
    private Integer quantity;
    private Integer quantity_sold;
    private Integer category_id;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBar_code() {
        return bar_code;
    }

    public void setBar_code(Integer bar_code) {
        this.bar_code = bar_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(Integer quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
