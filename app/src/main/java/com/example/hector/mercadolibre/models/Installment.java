package com.example.hector.mercadolibre.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Installment {
    private String payment_method_id;
    private String payment_type_id;
    private CardIssuers issuer;
    @SerializedName("payer_costs")
    private List<PayerCost> payerCosts;

    public Installment(String payment_method_id, String payment_type_id, CardIssuers issuer, List<PayerCost> payerCosts) {
        this.payment_method_id = payment_method_id;
        this.payment_type_id = payment_type_id;
        this.issuer = issuer;
        this.payerCosts = payerCosts;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(String payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public CardIssuers getIssuer() {
        return issuer;
    }

    public void setIssuer(CardIssuers issuer) {
        this.issuer = issuer;
    }

    public List<PayerCost> getPayer_costs() {
        return payerCosts;
    }

    public void setPayer_costs(List<PayerCost> payerCosts) {
        this.payerCosts = payerCosts;
    }
}
