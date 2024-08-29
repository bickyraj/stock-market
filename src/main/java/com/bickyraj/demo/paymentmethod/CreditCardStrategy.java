package com.bickyraj.demo.paymentmethod;

public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String cardHolderName;

    public CreditCardStrategy(String cardNumber, String cvv, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("paid by credit card " + amount);
    }
}
