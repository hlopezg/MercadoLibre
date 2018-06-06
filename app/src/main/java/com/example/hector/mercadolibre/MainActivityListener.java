package com.example.hector.mercadolibre;

import com.example.hector.mercadolibre.models.CardIssuers;
import com.example.hector.mercadolibre.models.PayerCost;
import com.example.hector.mercadolibre.models.PaymentMethod;

public interface MainActivityListener {
    void showProgressLayout(String text);
    void hideProgressLayout();
    void toast(String text);

    void goToPaymentAmount();
    void goToPaymentMethod(int amount);
    void goToCardIssuers(PaymentMethod paymentMethod);
    void goToInstallment(CardIssuers cardIssuers);
    void goToSummary(PayerCost payerCost);
    void goToNoNetwork();
}
