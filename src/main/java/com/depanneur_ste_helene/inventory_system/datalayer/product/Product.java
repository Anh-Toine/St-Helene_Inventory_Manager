package com.depanneur_ste_helene.inventory_system.datalayer.product;
import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    
    @Column(name = "bar_code", unique = true, nullable = false)
    private String barCode;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "brand")
    private String brand;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "quantity")
    private Integer quantity;
    
    @Column(name = "quantity_sold")
    private Integer quantitySold;
    
    @Column(name = "category_id")
    private String categoryId;

    public Product(Integer productId, String barCode, String productName, String brand, double price, Integer quantity, Integer quantitySold, String categoryId) {
        this.productId = productId;
        this.barCode = barCode;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.quantitySold = quantitySold;
        this.categoryId = categoryId;
    }

    public Product() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}