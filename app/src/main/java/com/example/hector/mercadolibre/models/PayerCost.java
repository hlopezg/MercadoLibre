package com.example.hector.mercadolibre.models;

public class PayerCost {
    private String recommendedMessage;
    private int installmentAmount;
    private int totalAmount;

    public PayerCost(String recommendedMessage, int installmentAmount, int totalAmount) {
        this.recommendedMessage = recommendedMessage;
        this.installmentAmount = installmentAmount;
        this.totalAmount = totalAmount;
    }

    public String getRecommendedMessage() {
        return recommendedMessage;
    }

    public void setRecommendedMessage(String recommendedMessage) {
        this.recommendedMessage = recommendedMessage;
    }

    public int getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(int installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    /*
     "recommended_message": "1 cuota de $ 40.000,00 ($ 40.000,00)",
        "installment_amount": 40000,
        "total_amount": 40000
     */
}
