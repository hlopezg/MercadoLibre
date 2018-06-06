package com.example.hector.mercadolibre.main.method;

import com.example.hector.mercadolibre.models.PaymentMethod;

interface OnPaymentMethodInteractionListener {
    void itemSelected(PaymentMethod paymentMethod);
}
