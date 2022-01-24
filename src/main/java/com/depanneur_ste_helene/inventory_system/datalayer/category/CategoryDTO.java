package com.depanneur_ste_helene.inventory_system.datalayer.category;

public class CategoryDTO {

    private String categoryId;

    private String categoryName;

    private boolean taxable;

    private double tax;

    public CategoryDTO(String categoryId, String categoryName, boolean taxable, double tax) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.taxable = taxable;
        this.tax = tax;
    }

    public CategoryDTO() {
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
