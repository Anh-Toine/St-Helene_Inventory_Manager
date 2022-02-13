package com.depanneur_ste_helene.inventory_system.datalayer.supplier;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "supplier_id")
    private String supplierId = UUID.randomUUID().toString();

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "representative_name")
    private String representativeName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Supplier(Integer id, String supplierId, String supplierName, String representativeName, String email, String phoneNumber) {
        this.id = id;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.representativeName = representativeName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Supplier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}
