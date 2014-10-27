package com.ptngaye.spocktutorial;


public class PaymentResult {
    private final boolean failed;

    public PaymentResult(boolean failed) {
        this.failed = failed;
    }

    public boolean isFailed() {
        return failed;
    }
}
