package com.example.hector.mercadolibre.models;

import com.google.gson.annotations.SerializedName;

public class PayerCost {
    @SerializedName("installments")
    private String installments;
    @SerializedName("recommended_message")
    private String recommendedMessage;
    @SerializedName("total_amount")
    private int totalAmount;

    public PayerCost(String installments, String recommendedMessage, int totalAmount) {
        this.installments = installments;
        this.recommendedMessage = recommendedMessage;
        this.totalAmount = totalAmount;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getRecommendedMessage() {
        return recommendedMessage;
    }

    public void setRecommendedMessage(String recommendedMessage) {
        this.recommendedMessage = recommendedMessage;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
