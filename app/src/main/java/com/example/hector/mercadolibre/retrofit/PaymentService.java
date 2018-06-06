package com.example.hector.mercadolibre.retrofit;

import com.example.hector.mercadolibre.models.CardIssuers;
import com.example.hector.mercadolibre.models.Installment;
import com.example.hector.mercadolibre.models.PaymentMethod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaymentService {
    @GET("payment_methods")
    Call<List<PaymentMethod>> getPaymentMethods(@Query("public_key") String publicKey);

    @GET("payment_methods/card_issuers")
    Call<List<CardIssuers>> getCardIssuers(@Query("public_key") String publicKey, @Query("payment_method_id") String paymentMethodId);

    @GET("payment_methods/installments")
    Call<List<Installment>> getInstallment(@Query("public_key") String publicKey, @Query("amount") int amount, @Query("payment_method_id") String paymentMethodId, @Query("issuer.id") String issuerId);
}
