package com.depanneur_ste_helene.inventory_system.datalayer;
import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "taxable")
    private boolean taxable;

    @Column(name = "tax")
    private double tax;

    public Category(Integer categoryId, String categoryName, boolean taxable, double tax) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.taxable = taxable;
        this.tax = tax;
    }

    public Category() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
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
