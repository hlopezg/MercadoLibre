package com.example.hector.mercadolibre;

import com.example.hector.mercadolibre.models.PaymentMethod;

public interface MainActivityListener {
    void showProgressLayout(String text);
    void hideProgressLayout();

    void goToPaymentAmount();
    void goToPaymentMethod(int amount);
    void goToCardIssuers(PaymentMethod paymentMethod);
    void goToInstallment();
}
