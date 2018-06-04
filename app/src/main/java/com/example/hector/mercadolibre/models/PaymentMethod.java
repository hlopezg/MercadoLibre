package com.example.hector.mercadolibre.models;

import com.google.gson.annotations.SerializedName;

public class PaymentMethod {
    private String id;
    private String name;
    @SerializedName("payment_type_id")
    private String paymentTypeId;
    @SerializedName("secure_thumbnail")
    private String secureThumbnail;
    private String thumbnail;
    @SerializedName("min_allowed_amount")
    private String minAllowedAmount;
    @SerializedName("max_allowed_amount")
    private String maxAllowedAmount;

    public PaymentMethod(String id, String name, String paymentTypeId, String secureThumbnail, String thumbnail, String minAllowedAmount, String maxAllowedAmount) {
        this.id = id;
        this.name = name;
        this.paymentTypeId = paymentTypeId;
        this.secureThumbnail = secureThumbnail;
        this.thumbnail = thumbnail;
        this.minAllowedAmount = minAllowedAmount;
        this.maxAllowedAmount = maxAllowedAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    public void setSecureThumbnail(String secureThumbnail) {
        this.secureThumbnail = secureThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMinAllowedAmount() {
        return minAllowedAmount;
    }

    public void setMinAllowedAmount(String minAllowedAmount) {
        this.minAllowedAmount = minAllowedAmount;
    }

    public String getMaxAllowedAmount() {
        return maxAllowedAmount;
    }

    public void setMaxAllowedAmount(String maxAllowedAmount) {
        this.maxAllowedAmount = maxAllowedAmount;
    }

    /*"id": "visa",
            "name": "Visa",
            "payment_type_id": "credit_card",
            "status": "active",
            "secure_thumbnail": "https://www.mercadopago.com/org-img/MP3/API/logos/visa.gif",
            "thumbnail": "http://img.mlstatic.com/org-img/MP3/API/logos/visa.gif",
             "min_allowed_amount": 2,
    "max_allowed_amount": 250000,
            */
}
