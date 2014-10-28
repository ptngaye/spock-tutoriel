package com.ptngaye.spocktutorial;

import groovy.transform.EqualsAndHashCode;

public class Order {
    private final float amount;
    private final String reference;
    private final String customerReference;
    private OrderStatus status;
    private String paymentTransactionId;

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

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Order save() {
        //Persister la commande
        return this;
    }
}
