package com.ptngaye.spocktutorial;


public class PaymentCard {
    private final String type;
    private final String number;
    private final String expMonth;
    private final String expYear;
    private final String cvv;

    public PaymentCard(String type, String number, String expMonth, String expYear, String cvv) {
        this.type = type;
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public String getCvv() {
        return cvv;
    }
}
