package com.depanneur_ste_helene.inventory_system.datalayer.category;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_id")
    private String categoryId = UUID.randomUUID().toString();

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "taxable")
    private boolean taxable;

    @Column(name = "tax")
    private double tax;

    public Category(Integer id, String categoryId, String categoryName, boolean taxable, double tax) {
        this.id = id;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.taxable = taxable;
        this.tax = tax;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
