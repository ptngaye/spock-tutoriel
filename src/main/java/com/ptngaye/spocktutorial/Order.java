package com.ptngaye.spocktutorial;


public class Order {
    private final float amount;
    private final String reference;
    private final String customerReference;
    private OrderStatus status;

    public Order(float amount, String reference, String customerReference) {
        this.amount = amount;
        this.reference = reference;
        this.customerReference = customerReference;
        this.status = OrderStatus.CREATED;
    }

    public float getAmount() {
        return amount;
    }

    public String getReference() {
        return reference;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Order save() {
        //Persister la donnee
        return this;
    }
}
