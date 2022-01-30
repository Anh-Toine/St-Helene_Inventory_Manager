package com.depanneur_ste_helene.inventory_system.datalayer.order;

public class OrderCreateDTO {

    private String orderDate;

    private boolean received;

    private boolean payed;

    private int supplierId;

    public OrderCreateDTO(String orderDate, boolean received, boolean payed, int supplierId) {
        this.orderDate = orderDate;
        this.received = received;
        this.payed = payed;
        this.supplierId = supplierId;
    }

    public OrderCreateDTO() {
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
