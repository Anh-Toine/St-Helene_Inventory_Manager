package com.depanneur_ste_helene.inventory_system.datalayer;

public class SupplierDTO {
    private String supplierName;
    private String representativeName;
    private String email;
    private String phoneNumber;

    public SupplierDTO(String supplierName, String representativeName, String email, String phoneNumber) {
        this.supplierName = supplierName;
        this.representativeName = representativeName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public SupplierDTO() {
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
