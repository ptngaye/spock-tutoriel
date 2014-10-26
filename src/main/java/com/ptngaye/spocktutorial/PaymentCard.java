package com.ptngaye.spocktutorial;


public class PaymentCard {
    private String cvv;
    private String numCard;
    private String nameOnCard;
    private int yearEndValidation;
    private int montEndValidation;

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getYearEndValidation() {
        return yearEndValidation;
    }

    public void setYearEndValidation(int yearEndValidation) {
        this.yearEndValidation = yearEndValidation;
    }

    public int getMontEndValidation() {
        return montEndValidation;
    }

    public void setMontEndValidation(int montEndValidation) {
        this.montEndValidation = montEndValidation;
    }
}
