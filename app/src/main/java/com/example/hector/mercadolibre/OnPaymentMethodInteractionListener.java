package com.example.hector.mercadolibre;

import com.example.hector.mercadolibre.models.PaymentMethod;

public interface OnPaymentMethodInteractionListener {
    void itemSelected(PaymentMethod paymentMethod);
}
