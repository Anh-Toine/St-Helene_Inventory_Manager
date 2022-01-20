package com.depanneur_ste_helene.inventory_system.datalayer;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "representative_name")
    private String representativeName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Supplier(Integer id, String supplierName, String representativeName, String email, String phoneNumber) {
        supplierId = id;
        this.supplierName = supplierName;
        this.representativeName = representativeName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Supplier() {
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer id) {
        supplierId = id;
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
