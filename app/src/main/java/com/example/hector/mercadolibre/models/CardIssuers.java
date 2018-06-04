package com.example.hector.mercadolibre.models;

public class CardIssuers {
    private int id;
    private String name;
    private String secureThumbnail;
    private String thumbnail;
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

    /*
     "id": "288",
    "name": "Tarjeta Shopping",
    "secure_thumbnail": "https://www.mercadopago.com/org-img/MP3/API/logos/288.gif",
    "thumbnail": "http://img.mlstatic.com/org-img/MP3/API/logos/288.gif",
    "processing_mode": "aggregator",
    "merchant_account_id": null
     */
}
