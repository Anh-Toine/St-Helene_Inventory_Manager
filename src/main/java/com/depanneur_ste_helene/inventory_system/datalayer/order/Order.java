package com.depanneur_ste_helene.inventory_system.datalayer.order;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private UUID orderId = UUID.randomUUID();

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "received")
    private boolean received;

    @Column(name = "payed")
    private boolean payed;

    @Column(name = "supplier_id")
    private int supplierId;

    public Order(Integer id, UUID orderId, String orderDate, boolean received, boolean payed,
                 int supplierId) {
        this.id = id;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.received = received;
        this.payed = payed;
        this.supplierId = supplierId;
    }

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

}
