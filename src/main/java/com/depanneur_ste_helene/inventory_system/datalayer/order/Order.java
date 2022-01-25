package com.depanneur_ste_helene.inventory_system.datalayer.order;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "received")
    private boolean received;

    @Column(name = "payed")
    private boolean payed;

    @Column(name = "supplier_id")
    private int supplierId;

    public Order(Integer orderId, Date orderDate, boolean received, boolean payed, int supplierId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.received = received;
        this.payed = payed;
        this.supplierId = supplierId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Order() {

    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
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
