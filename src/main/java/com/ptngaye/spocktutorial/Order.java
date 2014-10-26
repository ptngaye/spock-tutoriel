package com.ptngaye.spocktutorial;


public class Order {
    private final float amount;
    private final String reference;
    private final String customerReference;
    private boolean paid;

    public Order(float amount, String reference, String customerReference) {
        this.amount = amount;
        this.reference = reference;
        this.customerReference = customerReference;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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
}
