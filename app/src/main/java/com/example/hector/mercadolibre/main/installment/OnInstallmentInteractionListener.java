package com.example.hector.mercadolibre.main.installment;

import com.example.hector.mercadolibre.models.PayerCost;

interface OnInstallmentInteractionListener {
    void itemSelected(PayerCost payerCost);
}
