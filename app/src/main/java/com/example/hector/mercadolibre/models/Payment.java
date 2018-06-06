package com.example.hector.mercadolibre.models;

public class Payment {
    private int amount;
    private PaymentMethod paymentMethod;
    private CardIssuers cardIssuers;
    private PayerCost payerCost;

    public Payment(){

    }

    public Payment(int amount, PaymentMethod paymentMethod, CardIssuers cardIssuers, PayerCost payerCost) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.cardIssuers = cardIssuers;
        this.cardIssuers = cardIssuers;
        this.payerCost = payerCost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CardIssuers getCardIssuers() {
        return cardIssuers;
    }

    public void setCardIssuers(CardIssuers cardIssuers) {
        this.cardIssuers = cardIssuers;
    }

    public PayerCost getPayerCost() {
        return payerCost;
    }

    public void setPayerCost(PayerCost payerCost) {
        this.payerCost = payerCost;
    }
}
