package com.example.hector.mercadolibre.models;

public class Payment {
    private int amount;
    private PaymentMethod paymentMethod;
    private CardIssuers cardIssuers;
    private Installment installment;

    public Payment(){

    }

    public Payment(int amount, PaymentMethod paymentMethod, CardIssuers cardIssuers, Installment installment) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.cardIssuers = cardIssuers;
        this.cardIssuers = cardIssuers;
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

    public Installment getInstallment() {
        return installment;
    }

    public void setInstallment(Installment installment) {
        this.installment = installment;
    }
}
