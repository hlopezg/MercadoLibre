package com.example.hector.mercadolibre.presenter;

import android.content.Context;

import com.example.hector.mercadolibre.models.CardIssuers;
import com.example.hector.mercadolibre.models.PaymentMethod;

import java.util.List;

public interface PaymentMVP {
    interface PaymentMethodView{
        void onSuccesfullGetPaymentMethod(List<PaymentMethod> paymentMethodList);
        void onFailureGetPaymentMethod();
    }

    interface PaymentCardIssuersView{
        void onSuccesfullGetCardIssuers(List<CardIssuers> cardIssuersList);
        void onFailureGetCardIssuers();
    }

    interface PaymentInstallmentView{
        void onSuccesfullGetInstallment();
        void onFailureGetInstallment();
    }

    interface PaymentMethodPresenter{
        void setView(PaymentMethodView view);
        void getPaymentMethod(Context context);
    }

    interface PaymentCardIssuersPresenter{
        void setView(PaymentCardIssuersView view);
        void getCardIssuers(Context context, String paymentMethodId);
    }

    interface PaymentInstallmentPresenter{
        void setView(PaymentInstallmentView view);
        void getInstallment(Context context, String paymentMethodId, String issuerId);
    }
}
