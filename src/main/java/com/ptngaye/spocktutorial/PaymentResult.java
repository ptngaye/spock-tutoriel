package com.ptngaye.spocktutorial;


public class PaymentResult {
    private final String transactionId;
    
    private final boolean failed;

    public PaymentResult() {
        this.transactionId = null;
        this.failed = true;
    }

    public PaymentResult(String transactionId) {
        this.transactionId = transactionId;
        this.failed = true;
    }

    public boolean isFailed() {
        return failed;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
