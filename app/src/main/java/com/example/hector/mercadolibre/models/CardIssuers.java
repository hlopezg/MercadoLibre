package com.example.hector.mercadolibre.models;

import com.google.gson.annotations.SerializedName;

public class CardIssuers {
    private int id;
    private String name;
    @SerializedName("secure_thumbnail")
    private String secureThumbnail;
    private String thumbnail;
    @SerializedName("merchant_account_id")
    private String merchantAccountId;

    public CardIssuers(int id, String name, String secureThumbnail, String thumbnail, String merchantAccountId) {
        this.id = id;
        this.name = name;
        this.secureThumbnail = secureThumbnail;
        this.thumbnail = thumbnail;
        this.merchantAccountId = merchantAccountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMerchantAccountId() {
        return merchantAccountId;
    }

    public void setMerchantAccountId(String merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }
}
