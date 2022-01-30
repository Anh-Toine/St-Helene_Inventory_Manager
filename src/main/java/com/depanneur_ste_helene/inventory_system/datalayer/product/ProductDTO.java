package com.depanneur_ste_helene.inventory_system.datalayer.product;

public class ProductDTO {
    private String barCode;
    private String productName;
    private String brand;
    private double price;
    private Integer quantity;
    private Integer quantitySold;
    private Integer categoryId;

    public ProductDTO(String barCode, String productName, String brand, double price, Integer quantity, Integer quantitySold, Integer categoryId) {
        this.barCode = barCode;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.quantitySold = quantitySold;
        this.categoryId = categoryId;
    }

    public ProductDTO() {
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Integer getCategoryId() { return categoryId; }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
