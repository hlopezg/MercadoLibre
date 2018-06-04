package com.example.hector.mercadolibre.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.Utilities.Constants;
import com.example.hector.mercadolibre.models.CardIssuers;
import com.example.hector.mercadolibre.retrofit.PaymentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentCardIssuersPresenter implements PaymentMVP.PaymentCardIssuersPresenter, Callback<List<CardIssuers>> {
    private PaymentMVP.PaymentCardIssuersView view;

    private PaymentService createPaymentService(Context context){
        final String BASE_URL = context.getString(R.string.server_path);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(PaymentService.class);
    }

    @Override
    public void setView(PaymentMVP.PaymentCardIssuersView view) {
        this.view = view;
    }

    @Override
    public void getCardIssuers(Context context, String paymentMethodId) {
        PaymentService paymentService = createPaymentService(context);

        Call<List<CardIssuers>> call = paymentService.getCardIssuers(Constants.PUBLIC_KEY, paymentMethodId);
        call.enqueue(this);
    }


    @Override
    public void onResponse(@NonNull Call<List<CardIssuers>> call, @NonNull Response<List<CardIssuers>> response) {
        List<CardIssuers> paymentMethodList = response.body();
        if(view != null)
            view.onSuccesfullGetCardIssuers(paymentMethodList);
    }

    @Override
    public void onFailure(@NonNull Call<List<CardIssuers>> call, @NonNull Throwable t) {
        if(view != null)
            view.onFailureGetCardIssuers();
    }
}
